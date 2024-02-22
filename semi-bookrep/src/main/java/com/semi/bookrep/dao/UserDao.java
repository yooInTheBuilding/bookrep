package com.semi.bookrep.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.semi.bookrep.dto.BookDTO;
import com.semi.bookrep.dto.UserDTO;

public interface UserDao {
	@Select("SELECT count(*) FROM user")
	int getUserCnt();
	
<<<<<<< HEAD
	List<UserDTO> getUserList(String keyword);
=======
	boolean signIn(String email, String password);
>>>>>>> 481554b (home screen logic 1)

	
}
