package com.semi.bookrep.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.semi.bookrep.dao.UserDao;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
	

	@Autowired
	private UserDao userDao;
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		int cnt = userDao.getUserCnt();
		System.out.println(cnt);
		
		HttpSession session = request.getSession(false);
		
	
		if(session != null && session.getAttribute("loggedUser") != null) {
			// 로그인 정보(email값) 있음
			return "redirect:/home2";
		}else {
			// 로그인 정보 없음
			return "home1";
		}
		
	}
	
}
