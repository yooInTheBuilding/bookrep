package com.semi.bookrep.controller;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.semi.bookrep.dao.UserDao;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
	

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		int cnt = userDao.getUserCnt();
		System.out.println(cnt);
		return "home";
	}
	
}
