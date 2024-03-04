package com.semi.bookrep.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.bookrep.dao.FollowDao;
import com.semi.bookrep.dao.ReportDao;
import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.dto.ReportDTO;
import com.semi.bookrep.dto.UserDTO;
import com.semi.bookrep.util.MainUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HomeService {
	
	@Autowired
	public ReportDao reportDao;
	
	
	public List<PageDTO> getReportToHome(String email) {
		log.info("getReportToHome()");
		
		List<ReportDTO> reportList = reportDao.getReportOfFollowing(email);
		
		List<PageDTO> pageList = MainUtil.setPaging(reportList, 6);
		
		return pageList;
	}

	
}
