package com.semi.bookrep.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.semi.bookrep.dao.ReportDao;
import com.semi.bookrep.dto.ReportDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReportUService {
	
	@Autowired
	private ReportDao reportDao;

	public String isOwner(HttpSession session, ReportDTO reportDTO, Model model) {
		log.info("isOwner()");
		
		String view = null;
		String email = (String)session.getAttribute("email");
		if (email != reportDTO.getUserEmail()) {
			view = "redirect:report-detail?id=" + reportDTO.getId();
		}else {
			model.addAttribute("report", reportDTO);
			view = "update";
		}
		
		return view;
	}

	public void applyReportUpdate(ReportDTO reportDTO) {
		log.info("applyReportUpdate()");
		
		reportDao.applyReportUpdate(reportDTO);
	}

}
