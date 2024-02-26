package com.semi.bookrep.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.ui.Model;

import com.semi.bookrep.dto.BookDTO;
import com.semi.bookrep.dto.UserDTO;

public interface UserDao {
	@Select("SELECT count(*) FROM user")
	int getUserCnt();
	
	List<UserDTO> getUserList(String keyword);
	
	boolean signIn(@Param("email") String email, @Param("password") String password);

	boolean signUp(@Param("email") String email, @Param("password") String password, @Param("name") String name);

	UserDTO getUserByEmail(@Param("email") String email);

	
}
