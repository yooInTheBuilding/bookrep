package com.semi.bookrep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("bookmark")
	public String showBookmark(@RequestParam("email") String email, Model model) {
		log.info("showBookmark()");
		
		List<BookDTO> bookList = bookmarkService.getBookmarkByEmail(email);
		List<PageDTO> bookPageList = MainUtil.setPaging(bookList, 6);
		model.addAttribute("bookmarkList", bookPageList);
		
		return "bookmark";
	}
}
