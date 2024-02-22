package com.semi.bookrep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.semi.bookrep.dto.BookDTO;
import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.dto.UserDTO;
import com.semi.bookrep.service.SearchService;
import com.semi.bookrep.util.MainUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@GetMapping("search")
	public String getTotalSearchByString(@RequestParam("keyword") String keyword, Model model) {
		log.info("controller.getTotalSearchByString()");
		
		List<UserDTO> userList = searchService.getUserByString(keyword);
		List<BookDTO> bookList = searchService.getBookByString(keyword);
		for (int i = 0; i < userList.size(); i++) {
			log.info(userList.get(i).getName());
		}
		for (int i = 0; i < bookList.size(); i++) {
			log.info(bookList.get(i).getName());
		}
		List<PageDTO> userPageList = MainUtil.setPaging(userList, 5);
		List<PageDTO> bookPageList = MainUtil.setPaging(bookList, 5);
		model.addAttribute("userList", userPageList);
		model.addAttribute("bookList", bookPageList);
		return "search";
	}
}
