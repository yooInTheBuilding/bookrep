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
	public String home() {
		log.info("home1 화면 출력()");
		return "home1";
	}
	
	@PostMapping("/home")
	public String home(HttpSession session) {
		
		String email = (String) session.getAttribute("email");
		
		if(email != null) {
			log.info("home2 출력() ");
			return "redirect:/home";
		} else {
			return "home1";
		}
		
	}
	
}
