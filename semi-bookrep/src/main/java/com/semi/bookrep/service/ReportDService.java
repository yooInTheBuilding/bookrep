package com.semi.bookrep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.bookrep.dao.ReportDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReportDService {
	
	@Autowired
	private ReportDao reportDao;

	public void deleteReportByReportId(Long id) {
		log.info("deleteReportByReportId()");
		
		reportDao.deleteReportByReportId(id);
		
	}

}
