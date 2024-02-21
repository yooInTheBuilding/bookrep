package com.semi.bookrep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.bookrep.dao.BookDao;
import com.semi.bookrep.dao.UserDao;
import com.semi.bookrep.dto.BookDTO;
import com.semi.bookrep.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SearchService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BookDao bookDao;
	
	public List<UserDTO> getUserByString(String keyword){
		log.info("service.getUserByString()");
		List<UserDTO> userList = userDao.getUserList(keyword);
		
		return userList;
	}
	
	public List<BookDTO> getBookByString(String keyword){
		log.info("service.getBookByString()");
		List<BookDTO> bookList = bookDao.getBookList(keyword);
		
		return bookList;
	}
}
