package com.semi.bookrep.dao;

import java.util.List;

import com.semi.bookrep.dto.FollowDTO;

public interface FollowDao {

	List<String> getFollowerByEmail(String email);

	List<String> getFollowingByEmail(String email);

	Integer isFollowing(FollowDTO followDTO);

	void follow(FollowDTO followDTO);

	void unfollow(FollowDTO followDTO);


}
