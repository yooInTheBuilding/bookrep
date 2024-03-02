package com.semi.bookrep.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.bookrep.dto.BookDTO;
import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.dto.ReportDTO;
import com.semi.bookrep.service.BookService;
import com.semi.bookrep.service.BookmarkService;
import com.semi.bookrep.util.MainUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookmarkService bookmarkService;
	
	
	@GetMapping("book-detail")
	public String showBookDetail(HttpSession session, @RequestParam("isbn") String isbn, Model model) {
		log.info("showBookDetail()");
		
		boolean isBookmark = bookmarkService.isBookmark(session, isbn);
		
		BookDTO bookDTO = bookService.getBookByIsbn(isbn);
		
		List<ReportDTO> reportList = bookService.getReportByIsbn(isbn);
		List<PageDTO> reportPageList = MainUtil.setPaging(reportList, 6);
		
		model.addAttribute("reportList", reportPageList);
		model.addAttribute("isBookmark", isBookmark);
		model.addAttribute("book", bookDTO);
		
		return "bookDetail";
	}
	
	@PostMapping("bookmark")
	@ResponseBody
	public String setBookmark(HttpSession session, @RequestParam("isbn") String isbn) {
		log.info("setBookmark()");
		
		bookmarkService.setBookmark(session, isbn);
		
		return "success";
	}
	
}
