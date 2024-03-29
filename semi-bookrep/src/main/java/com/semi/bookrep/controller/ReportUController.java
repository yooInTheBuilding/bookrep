package com.semi.bookrep.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.semi.bookrep.dto.ReportDTO;
import com.semi.bookrep.service.ReportRService;
import com.semi.bookrep.service.ReportUService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReportUController {
	
	@Autowired
	private ReportRService reportRService;
	
	@Autowired
	private ReportUService reportUService;
	
	@GetMapping("report-update")
	public String showReportUpdate(HttpSession session, @RequestParam("id") Long id, Model model) {
		log.info("showReportUpdate()");
		
		ReportDTO reportDTO = reportRService.getReportDetailByReportId(id);
		String view = reportUService.isOwner(session, reportDTO, model);
		
		return view;
	}
	
	@PostMapping("/apply-update")
	public String applyReportUpdate(@ModelAttribute ReportDTO reportDTO) {
	    log.info("applyReportUpdate()");
	    
	    reportUService.applyReportUpdate(reportDTO);
	    
	    return "redirect:/report-detail?id=" + reportDTO.getId();
	}
	
	
	
	
}
