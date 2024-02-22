package com.semi.bookrep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.bookrep.dao.UserDao;

@Service
public class SignService {
	
	@Autowired UserDao userDao;

	public boolean signIn(String email, String password) {
		return userDao.signIn(email, password);
	}

}