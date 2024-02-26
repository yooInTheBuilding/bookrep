package com.semi.bookrep.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.semi.bookrep.dao.UserDao;
import com.semi.bookrep.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SignService {
	
	@Autowired UserDao userDao;

	public String signIn(HttpSession session, String email, String password) {
		
		boolean loginResult = userDao.signIn(email, password);
		
		if(loginResult) {
			log.info("로그인 성공");
			
			UserDTO userDTO = userDao.getUserByEmail(email);
			session.setAttribute("loggedEmail", userDTO);
			
			return "redirect:/home";
			
		} else {
			log.info("로그인 실패");
			return "signIn";
		}
		
	}

	public String signUp(String email, String password, String name) {
		
		boolean joinResult = userDao.signUp(email, password, name); 
		
		if(joinResult) {
			log.info("회원가입 성공");
			return "home1";
		} else {
			log.info("회원가입 실패");
			return "signUp";
		}
	}


}