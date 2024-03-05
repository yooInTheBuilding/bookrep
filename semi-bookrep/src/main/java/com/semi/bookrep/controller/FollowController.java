package com.semi.bookrep.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.service.FollowService;
import com.semi.bookrep.util.MainUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FollowController {
	
	@Autowired
	private FollowService followService;
	
	
	@GetMapping("following")
	public String showFollowing(@RequestParam("email") String email, Model model) {
		log.info("showFollowing()");
		
		List<String> followingList = followService.getFollowingByEmail(email);
		
		List<PageDTO> followingPageList = MainUtil.setPaging(followingList, 6);
		
		model.addAttribute("followingList", followingPageList);
		
		return "following";
	}
	
	@GetMapping("follower")
	public String showFollower(@RequestParam("email") String email, Model model) {
		log.info("showFollower()");
		
		List<String> followerList = followService.getFollowerByEmail(email);
		
		List<PageDTO> followerPageList = MainUtil.setPaging(followerList, 6);
		
		model.addAttribute("followingList", followerPageList);
		
		return "follower";
	}
	
	@PostMapping("follow")
	@ResponseBody
	public String follow(@RequestParam("email") String followerEmail, HttpSession session) {
		log.info("follow()");
		
		String followeeEmail = (String)session.getAttribute("email");
		
		followService.follow(followerEmail, followeeEmail);
		
		return "redirect:feed/" + followerEmail;
	}
	
	@PostMapping("unfollow")
	@ResponseBody
	public String unfollow(@RequestParam("email") String followerEmail, HttpSession session) {
		log.info("unfollow()");
		
		String followeeEmail = (String)session.getAttribute("email");
		
		followService.unfollow(followerEmail, followeeEmail);
		
		return "redirect:feed/" + followerEmail;
	}
	
}
