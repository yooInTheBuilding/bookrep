package com.semi.bookrep.controller;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.semi.bookrep.service.HomeService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping("/")
	public String main() {
		return "home1";
	}
	
	@GetMapping("/home")
	public String home() {
		log.info("home 화면 출력()");
		return "home1";
	}
	
	@PostMapping("/home")
	public String home(HttpSession session) {
		
		String email = (String) session.getAttribute("email");

		if(email != null) {
			return "home2";
		} else {
			return "home1";
		}
		
	}
	
}
