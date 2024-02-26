package com.semi.bookrep.dao;

import java.util.List;

import com.semi.bookrep.dto.BookDTO;

import lombok.NonNull;

public interface BookDao {
	
	List<BookDTO> getBookList(String keyword);

	List<String> getImageList(String bookIsbn);
	
}
