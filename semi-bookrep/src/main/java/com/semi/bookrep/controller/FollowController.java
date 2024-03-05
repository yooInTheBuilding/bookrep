package com.semi.bookrep.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.dto.UserDTO;
import com.semi.bookrep.service.FollowService;
import com.semi.bookrep.util.MainUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FollowController {
	
	@Autowired
	private FollowService followService;
	
	
	
	@GetMapping("following/{email}")
	public String showFollowing(@PathVariable String email,
								Model model,
								@RequestParam(required = false) Integer pageNum) {
		log.info("showFollowing()");
		
		List<String> followingList = followService.getFollowingByEmail(email);
		Integer currentPage = 1;
		if (pageNum != null) {
			currentPage = pageNum;
		}
		List<String> currentFollowingList = MainUtil.setPagingFollow(followingList, currentPage);
		
		List<UserDTO> currentFollowingUserList = new ArrayList<UserDTO>();
		for (String userEmail : currentFollowingList) {
			currentFollowingUserList.add(followService.getUserByEmail(userEmail));
		}
		
		model.addAttribute("followingList", currentFollowingUserList);
		model.addAttribute("currentPageNum", currentPage);
		model.addAttribute("totalFollowingSize", followingList.size());
		model.addAttribute("email", email);
		return "following";
	}
	
	@GetMapping("follower/{email}")
	public String showFollower(@PathVariable String email,
								Model model,
								@RequestParam(required = false) Integer pageNum) {
		log.info("showFollower()");
		
		List<String> followerList = followService.getFollowerByEmail(email);
		Integer currentPage = 1;
		if (pageNum != null) {
			currentPage = pageNum;
		}
		List<String> currentFollowerList = MainUtil.setPagingFollow(followerList, currentPage);
		
		List<UserDTO> currentFollowerUserList = new ArrayList<UserDTO>();
		for (String userEmail : currentFollowerList) {
			currentFollowerUserList.add(followService.getUserByEmail(userEmail));
		}
		
		model.addAttribute("followerList", currentFollowerUserList);
		model.addAttribute("currentPageNum", currentPage);
		model.addAttribute("totalFollowerSize", followerList.size());
		model.addAttribute("email", email);
		
		return "follower";
	}
	
	@PostMapping("/follow")
	@ResponseBody
	public String follow(@RequestParam("email") String followerEmail, HttpSession session) {
		log.info("follow()");
		
		String followeeEmail = (String)session.getAttribute("email");
		
		followService.follow(followerEmail, followeeEmail);
		
		return "redirect:feed/" + followerEmail;
	}
	
	@PostMapping("/unfollow")
	@ResponseBody
	public String unfollow(@RequestParam("email") String followerEmail, HttpSession session) {
		log.info("unfollow()");
		
		String followeeEmail = (String)session.getAttribute("email");
		
		followService.unfollow(followerEmail, followeeEmail);
		
		return "redirect:feed/" + followerEmail;
	}
	
}
