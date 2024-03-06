package com.semi.bookrep.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.semi.bookrep.dto.CommentDTO;
import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.dto.ReportDTO;
import com.semi.bookrep.service.ReportRService;
import com.semi.bookrep.util.MainUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReportRController {
	
	@Autowired
	private ReportRService reportRService; 
	
	@GetMapping("report-detail")
	public String showReportDetail(@RequestParam("id") Long id, HttpSession session,Model model) {
		log.info("showReportDetail()");
		
		String loggedInUserEmail = (String) session.getAttribute("email");
		
		ReportDTO reportDTO = reportRService.getReportDetailByReportId(id);
		List<CommentDTO> commentList = reportRService.getCommentByReportId(id);
		List<PageDTO> pageList = MainUtil.setPaging(commentList, 6);
		Integer likeValue = reportRService.getLikeValueByReportId(id);
		Integer isLike = reportRService.isLike(loggedInUserEmail, id);
		
		boolean isLikeBool = false;
		if (isLike == 1) {
			isLikeBool = true;
		}
		
		model.addAttribute("report", reportDTO);
		model.addAttribute("commentList", pageList);
		model.addAttribute("likeValue", likeValue);
		model.addAttribute("isLike", isLikeBool);
		
		
		return "reportDetail";
	}
	
	@PostMapping("like")
	public String setLike(@RequestParam("id") Long id, HttpSession session) {
		log.info("setLike()");
		
		String email = (String) session.getAttribute("email");
		
		reportRService.setLike(email, id);
		
		return "redirect: report-detail?id=" + id;
	}
	
	@PostMapping("comment")
	public String setComment(@RequestParam("id") Long id, HttpSession session, @RequestParam("comment") String comment) {
		log.info("setComment()");
		
		String email = (String) session.getAttribute("email");
		
		reportRService.setComment(email, id, comment);
		
		return "redirect: report-detail?id=" + id;
	}
	
	
	
	
	
	
	
	
}
