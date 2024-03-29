package com.semi.bookrep.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.semi.bookrep.service.ReportDService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReportDController {
	
	@Autowired
	private ReportDService reportDService;
	
	@GetMapping("delete")
	public String deleteReportByReportId(@RequestParam("id") Long id, HttpSession session, RedirectAttributes rttr , @RequestParam("reportUserEmail") String reportEmail) {
		log.info("deleteReportByReportId()");
		
		String email = (String)session.getAttribute("email");
		String msg = null;
		String view = null;
		if (email == null || !email.equals(reportEmail)) {
			msg = "you are not an owner of this report";
			view = "redirect:/report-detail?id=" + id;
		}else {
			try {
				reportDService.deleteReportByReportId(id);
				msg = "delete complete";
				view = "redirect:/";
			} catch (Exception e) {
				e.printStackTrace();
				msg = "delete failed";
				view = "redirect:/report-detail?id=" + id;
			}
		}
		rttr.addFlashAttribute("msg", msg);
		return view;
	}
}
