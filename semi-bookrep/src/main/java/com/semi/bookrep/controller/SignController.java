package com.semi.bookrep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.semi.bookrep.service.SignService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class SignController {

	@Autowired SignService signService;
	
	
	//로그인 이동
	@GetMapping("sign-in")
	public String showSignIn() {
		log.info("로그인 화면 이동");
		return "signIn";
	}
	
	// 로그인 로직
	@PostMapping("sign-in")
	public String signIn(HttpSession session, @RequestParam String email, @RequestParam String password) {
		log.info("email:{}, pw:{}", email, password);
		
		String view = signService.signIn(session, email, password);
		
		return view;
	}
	
	@GetMapping("sign-out")
	public String signOut(HttpSession session) {
		session.invalidate();
		log.info("로그아웃");
		return "home1";
	}
	
	
}