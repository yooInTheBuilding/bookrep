package com.semi.bookrep.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.bookrep.dto.ReportDTO;
import com.semi.bookrep.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HomeService {

	@Autowired
	private UserDTO userDTO;
	
	
	public String getReportToHome(UserDTO user){
		log.info("getReportToHome()");
		
		
		
		return "home2";
	}
}
