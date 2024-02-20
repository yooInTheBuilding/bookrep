package com.semi.bookrep.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.semi.bookrep.dao.ReportDao;
import com.semi.bookrep.service.FeedService;
import com.semi.bookrep.service.FollowService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FeedController {
	@Autowired
	private FeedService feedService;
	private FollowService followService;

	@GetMapping("feed")
	public String showFeed(String userEmail, HttpSession session, Model model) {

		// 세션에서 현재 로그인한 사용자 이메일 가져옴.
		String loggedInUserEmail = (String) session.getAttribute("userEmail");

		// 매개변수인 userEmail을 사용해서 해당 유저의 독후감 정보를 가져옴.
		List<ReportDao> sessionItems = feedService.getReportSummaryById(userEmail);

		// 페이지 주인인 유저의 정보를 전달
		model.addAttribute("userEmail", userEmail);;

		// 독후감 정보 추가
		model.addAttribute("sessionItems", sessionItems);

		// 로그인한 사용자와 현재 보고 있는 페이지의 주인이 같은가 판별
		if (loggedInUserEmail != null && loggedInUserEmail.equals(userEmail)) {
			// 같은 경우 로그인한 사용자의 추가 정보를 모델에 추가
			model.addAttribute("isCurrentUser", true);
			System.out.println("로그인유저==페이지유저");
		} else {
			model.addAttribute("isCurrentUser", false);
			System.out.println("로그인유저!=페이지유저");
		}

		if (userEmail != null) {
			// 팔로워 수 출력
			int followerCnt = followService.getFollowerValueById(userEmail);
			System.out.println(followerCnt);
			model.addAttribute("followerCnt", followerCnt);

			// 팔로잉 수 출력
			int followingCnt = followService.getFollowingValueById(userEmail);
			model.addAttribute("followingCnt", followingCnt);
			
			// 잘 담겼나 확인용
			System.out.println("model = " + model);
		} else {
		    // userEmail이 null인 경우 처리
		    System.out.println("userEmail이 null입니다.");
		}

		return "feed";
	}
}
