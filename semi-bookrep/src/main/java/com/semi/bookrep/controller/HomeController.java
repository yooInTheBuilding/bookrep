package com.semi.bookrep.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@GetMapping("/")
	public String main() {
		return "home1";
	}

	@GetMapping("/home")
	public String home(HttpSession session) {

		String email = (String) session.getAttribute("email");

		log.info(email);
		
		if (email != null) {
			log.info("home2");
			return "home2";
		} else {
			log.info("home1");
			return "redirect:/";
		}
	}
}
