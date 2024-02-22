package com.semi.bookrep.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.bookrep.controller.FeedController;
import com.semi.bookrep.dao.FollowDao;
import com.semi.bookrep.dto.FollowDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FollowService {

	@Autowired
	private FollowDao followDao;

	public int getFollowerValueById(String userEmail) {
		// 페이지 유저에 따른 팔로워 리스트 가져오기
		List<String> followerList = getFollowerById(userEmail);

		// 팔로워 수 저장
		int followerCnt = followerList.size();

		if (followerList == null) {
			followerCnt = 0;
		}
		return followerCnt;
	}

	public int getFollowingValueById(String userEmail) {
		// 페이지 유저에 따른 팔로잉 리스트 가져오기
		List<String> followingList = getFollowingById(userEmail);

		// 팔로잉 수 저장
		int followingCnt = followingList.size();
		
		if (followingList == null) {
			followingCnt = 0;
		}

		return followingCnt;
	}

	public List<String> getFollowerById(String userEmail) {
//		// 팔로워 목록 가져오기
//		List<String> followersEmailList = null;
////		List<String> followersEmailList = followDao.getFollowerEmailList(userEmail);
//		return followersEmailList;
		return null;
	}

	public List<String> getFollowingById(String userEmail) {
//		// 팔로잉 목록 가져오기
//		List<FollowDTO> followingList = null;
////		List<FollowDTO> followingList = followDao.getFollowingList(userEmail);
//
//		List<String> followingsEmailList = new ArrayList<>();
//
////		// 팔로잉의 이메일을 리스트에 저장
////		for (FollowDTO followDTO : followingList) {
////			followingsEmailList.add(followDTO.getFollowingEmail());
////		}
//
//		return followingsEmailList;
		return null;
	}
}
