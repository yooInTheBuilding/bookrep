package com.semi.bookrep.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.semi.bookrep.dto.BookDTO;
import com.semi.bookrep.dto.UserDTO;

public interface UserDao {
	@Select("SELECT count(*) FROM user")
	int getUserCnt();
	
	List<UserDTO> getUserList(String keyword);
	
	int signIn(Map<String, String> map);

	String getUserImage(String userEmail);

	int emailCheck(String email);

	void applySignUp(UserDTO userDTO);

	String getPassword(Map<String, String> map);

	UserDTO showModify(String email);

	void modify(UserDTO userDTO);

	void resign(String email);

	
}