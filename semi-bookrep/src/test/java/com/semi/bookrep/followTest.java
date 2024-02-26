package com.semi.bookrep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.semi.bookrep.service.FollowService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class followTest {

	@Autowired
	private FollowService followService;
	
	String userEmail = "aaa@aaa.com";
	
	@Test
	void followCntTest () {
		int testFollowerCnt = followService.getFollowerValueById(userEmail);
		int testFollowingCnt = followService.getFollowingValueById(userEmail);
		
		System.out.println(testFollowerCnt);
		System.out.println(testFollowingCnt);	
	}
}
