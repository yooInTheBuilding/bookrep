package com.semi.bookrep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.semi.bookrep.service.FollowService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class FollowTest {
	
	@Autowired
	private FollowService followService;

	@Test
	void getFollowerValueByEmailTest() {
		System.out.println(followService.getFollowerValueByEmail("ing06047"));
	}
	
	@Test
	void getFollowingValueByEmailTest() {
		System.out.println(followService.getFollowingValueByEmail("ing06047"));
	}
	
	@Test
	void getFollowerByEmailTest() {
		List<String> followerList = followService.getFollowerByEmail("ing06047");
		for (String string : followerList) {
			System.out.println("email: " + string);
		}
	}
	
	@Test
	void getFollowingByEmailTest() {
		List<String> followingList = followService.getFollowingByEmail("ing06047");
		for (String string : followingList) {
			System.out.println("email: " + string);
		}
	}
	
	@Test
	void followTest() {
		followService.follow("ing06047", "sw0263");
	}
	
	@Test
	void unfollowTest() {
		followService.unfollow("ing06047", "sw0263");
	}
	
	@Test
	void isFollowingTest() {
		System.out.println(followService.isFollowing("ing06047", "sw0263"));
	}

}
