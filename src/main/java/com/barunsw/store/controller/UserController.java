package com.barunsw.store.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.barunsw.store.constants.Result;
import com.barunsw.store.service.UserService;
import com.barunsw.store.vo.ResponseVo;
import com.barunsw.store.vo.UserVo;

@Controller
public class UserController {
	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/api/login", method=RequestMethod.POST)
	public ResponseEntity<ResponseVo> login(@RequestBody final UserVo paramData, final HttpServletRequest request) {
		LOGGER.debug("login paramData:{}", paramData);
		
		final HttpSession session = request.getSession();
		
		ResponseVo response = new ResponseVo();
		try {
			userService.signUp(paramData);
			
			session.setAttribute("USER", paramData);

			response.setResult(Result.OK);
		}
		catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			
			response.setResult(Result.FAIL);
		}
		
		return response.build();
	}
	
	@RequestMapping(value="/api/logout", method=RequestMethod.POST)
	public ResponseEntity<ResponseVo> logout(final HttpServletRequest request) {
		final HttpSession session = request.getSession();
		
		ResponseVo response = new ResponseVo();
		try {
			session.removeAttribute("USER");
			response.setResult(Result.OK);
		}
		catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);

			response.setResult(Result.FAIL);
		}
		
		return response.build();
	}
}
