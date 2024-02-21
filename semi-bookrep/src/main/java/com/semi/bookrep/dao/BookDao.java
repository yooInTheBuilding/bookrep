package com.semi.bookrep.dao;

import java.util.List;

import com.semi.bookrep.dto.BookDTO;

public interface BookDao {
	
	List<BookDTO> getBookList(String keyword);
	
}
