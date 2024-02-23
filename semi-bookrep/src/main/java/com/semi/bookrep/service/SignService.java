package com.semi.bookrep.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.bookrep.dao.UserDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SignService {
	
	@Autowired UserDao userDao;

	public String signIn(HttpSession session, String email, String password) {
		
		boolean loginResult = userDao.signIn(email, password);
		
		if(loginResult) {
			log.info("로그인 성공");
			session.setAttribute("email", email);
			return "redirect:/home";
			
		} else {
			log.info("로그인 실패");
			return "signIn";
		}
		
	}

}