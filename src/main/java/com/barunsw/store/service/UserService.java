package com.barunsw.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barunsw.store.mapper.UserDao;
import com.barunsw.store.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public int signUp(UserVo paramData) throws Exception {
		return userDao.signUp(paramData);
	}
}
