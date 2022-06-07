package com.barunsw.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barunsw.store.mapper.LoginDao;

@Service
public class LoginService {
	@Autowired
	private LoginDao loginDao;
	
	public int login() {
		return 0;
	}
}
