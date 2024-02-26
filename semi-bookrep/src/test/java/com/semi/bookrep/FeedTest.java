package com.semi.bookrep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.service.FeedService;
import com.semi.bookrep.service.FollowService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class FeedTest {
	
	@Autowired
	private FeedService feedService;
	
	String userEmail = "aaa@aaa.com";

	@Test
	void getReportSummaryByIdTtest() {
		List<PageDTO> testItems = feedService.getReportSummaryById(userEmail);
		System.out.println(testItems);
	}
	
	@Test
	void getReportValueByIdTest() {
		int testValue = feedService.getReportValueById(userEmail);
		System.out.println(testValue);	
	}
	
	@Test
	void getUserImageTest() {
		String testImage = feedService.getUserImage(userEmail);
		System.out.println(testImage);
	}
}
