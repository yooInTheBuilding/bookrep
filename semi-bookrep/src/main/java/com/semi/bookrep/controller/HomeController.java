package com.semi.bookrep.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.dto.ReportDTO;
import com.semi.bookrep.service.HomeService;
import com.semi.bookrep.util.MainUtil;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping("/")
	public String home(HttpSession session, Model model) {
		log.info("home()");
		
		String email = (String)session.getAttribute("email");
		
		String view = "home1";
		
		if (email != null && !email.isEmpty()) {
			List<ReportDTO> reportList = homeService.getReportToHome(email);
			List<PageDTO> reportPageList = MainUtil.setPaging(reportList, 6);
			model.addAttribute("reportList", reportPageList);
			
			view = "home2";
		}
		
		return view;
	}
	
	
}
