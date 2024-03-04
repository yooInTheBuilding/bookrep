package com.semi.bookrep.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.service.HomeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@Autowired
	HomeService homeService;
	
	@GetMapping("/")
	public String main() {
		return "home1";
	}
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
    
		String email = (String) session.getAttribute("email");
    
		log.info(email);
		
		if (email != null) {
			log.info("home2");

			List<PageDTO> pageList = homeService.getReportToHome(email);
			
			model.addAttribute("sessionItems", pageList);
			return "home2";
		} else {
			log.info("home1");
			return "redirect:/";
		}
	}
}
