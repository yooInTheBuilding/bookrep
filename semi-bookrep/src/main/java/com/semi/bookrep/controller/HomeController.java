package com.semi.bookrep.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.service.FeedService;
import com.semi.bookrep.service.HomeService;


import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {


	@Autowired
	private HomeService homeService;
	
	@Autowired
	private FeedService feedService;
	
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
	
	@PostMapping("get-image")
	@ResponseBody
	public String getImage(@RequestParam("email") String email) {
		log.info("getImage()");
		String imageAjax = feedService.getUserImage(email);
		return imageAjax;
	}
}

