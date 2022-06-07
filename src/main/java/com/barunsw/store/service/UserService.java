package com.barunsw.store.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barunsw.store.mapper.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public int login() {
		return 0;
	}
	
	public int insertUser(String email) throws Exception {
		Map<String, String> paramData = new HashMap<>();
		paramData.put("email", email);
		
		return userDao.insertUser(paramData);
	}
}
