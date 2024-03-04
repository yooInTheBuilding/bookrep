package com.semi.bookrep.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.bookrep.dao.BookDao;
import com.semi.bookrep.dao.ReportDao;
import com.semi.bookrep.dao.UserDao;
import com.semi.bookrep.dto.BookDTO;
import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.dto.ReportDTO;
import com.semi.bookrep.util.MainUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FeedService {
	@Autowired
	ReportDao reportDao;
	
	@Autowired
	BookDao bookDao;
	
	@Autowired
	ReportRService reportRService;
	
	@Autowired
	UserDao userDao;

	public List<PageDTO> getReportSummaryById(String userEmail) {

		log.info("getRepostSummarybyId()");
		
		List<ReportDTO> userReports = new ArrayList<>();
		
		log.info("getReportSummaryById() 진입시도");
		try {
			userReports = reportDao.getReportSummaryById(userEmail);
			System.out.println(userReports);
		} catch (Exception e) {
			log.info("getReportSummaryById에서 못 받아옴");
			e.printStackTrace();
		}
		
		List<Object> summaryList = new ArrayList<>();
		log.info("이미지 매칭 작업 시작");
		
		try {
	         for(ReportDTO reportDTO : userReports) {
	        	String image = bookDao.getImage(reportDTO.getBookIsbn());
	            
	            int likeValue = reportRService.getLikeValueByReportId(reportDTO.getId());
	            
	            Map<String, Object> map = new HashMap<String, Object>();
	            map.put("report", reportDTO);
	            map.put("image", image);
	            map.put("like", likeValue);
	            
	            summaryList.add(map);
	            log.info("잘 가져옴");
	         }
	      } catch (Exception e) {
	         log.info("이미지 못 받아옴.");
	         e.printStackTrace();
	         
	      }

	
		log.info("setPaging() 진입시도");
		
		try {
			List<PageDTO> reportSummaries = MainUtil.setPaging(summaryList, 6);
			System.out.println(reportSummaries);
			return reportSummaries;
		} catch (Exception e) {
			log.info("setPaging에서 못 받아옴");
			e.printStackTrace();
			return null;
		}
	}

	public int getReportValueById(String userEmail) {
		log.info("getReportValueById()");
		
		List<ReportDTO> userReports = reportDao.getReportSummaryById(userEmail);
		int reportValue = userReports.size();
		
		return reportValue;
	}

	public String getUserImage(String userEmail) {
		String userImage = userDao.getUserImage(userEmail);
		
		return userImage;
	}
}