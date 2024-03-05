package com.semi.bookrep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.semi.bookrep.dto.BookDTO;
import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.service.BookmarkService;
import com.semi.bookrep.util.MainUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BookmarkController {
	
	@Autowired
	private BookmarkService bookmarkService;
	
	@GetMapping("bookmark/{email}")
	public String showBookmark(@PathVariable String email,
								Model model,
								@RequestParam(required = false) Integer pageNum) {
		log.info("showBookmark()");
		
		List<BookDTO> bookList = bookmarkService.getBookmarkByEmail(email);
		Integer currentPageNum = 1;
		if (pageNum != null) {
			currentPageNum = pageNum;
		}
		List<BookDTO> currentBookList = MainUtil.setPagingBook(bookList, currentPageNum);
		model.addAttribute("bookmarkList", currentBookList);
		model.addAttribute("currentPageNum", currentPageNum);
		model.addAttribute("email", email);
		model.addAttribute("totalBookSize", bookList.size());
		return "bookmark";
	}
}
