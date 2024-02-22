package com.semi.bookrep.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.semi.bookrep.dto.BookDTO;
import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.service.ReportCService;
import com.semi.bookrep.util.MainUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReportCController {
	
	@Autowired
	private ReportCService reportCService;
	
	@GetMapping("write")
	public String showReportWriter() {
		log.info("showReportWriter()");
		return "write";
	}
	
	@GetMapping("book-search")
	public String getBookSearch(@RequestParam("keyword") String keyword, Model model) throws IOException, InterruptedException {
		log.info("getBookSearch()");
		List<BookDTO> bookList = reportCService.getBookByAPI(keyword);
		List<PageDTO> bookPageList = MainUtil.setPaging(bookList, 6);
		model.addAttribute("bookList", bookPageList);
		return "bookSearch";
	}
	
	
}
