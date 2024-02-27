package com.semi.bookrep.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.semi.bookrep.dto.UserDTO;
import com.semi.bookrep.service.SignService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SignController {

	@Autowired
	SignService signService;

	// 로그인 이동
	@GetMapping("sign-in")
	public String showSignIn() {
		log.info("로그인 화면 이동");
		return "signIn";
	}

	
	// 로그아웃 로직
	@GetMapping("sign-out")
	public String signOut(HttpSession session) {
		session.invalidate();
		log.info("로그아웃");
		return "home1";
	}

	
}