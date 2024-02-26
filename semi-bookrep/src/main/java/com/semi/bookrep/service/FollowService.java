package com.semi.bookrep.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.bookrep.dao.FollowDao;
import com.semi.bookrep.dto.FollowDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FollowService {

	@Autowired
	private FollowDao followDao;

	public int getFollowerValueById(String userEmail) {
		
		log.info("getFollowerValueById()");
		
		// 페이지 유저에 따른 팔로워 리스트 가져오기
		List<String> followerList = getFollowerById(userEmail);

		if (followerList == null || followerList.isEmpty()) {
	        return 0;
	    }
		
		// 팔로워 수 저장
		int followerCnt = followerList.size();

		return followerCnt;
	}

	public int getFollowingValueById(String userEmail) {
		// 페이지 유저에 따른 팔로잉 리스트 가져오기
		List<String> followingList = getFollowingById(userEmail);

        if (followingList == null || followingList.isEmpty()) {
            return 0;
        }
		
		// 팔로잉 수 저장
		int followingCnt = followingList.size();

		return followingCnt;
	}

	public List<String> getFollowerById(String userEmail) {

		return null;
	}

	public List<String> getFollowingById(String userEmail) {

		return null;
	}
}
