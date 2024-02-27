package com.semi.bookrep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.bookrep.dao.BookDao;
import com.semi.bookrep.dao.ReportDao;
import com.semi.bookrep.dto.BookDTO;
import com.semi.bookrep.dto.ReportDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private ReportDao reportDao;

	public BookDTO getBookByIsbn(String isbn) {
		log.info("getBookByIsbn()");
		
		BookDTO bookDTO = bookDao.getBookByIsbn(isbn);
		
		return bookDTO;
	}
	
	public List<ReportDTO> getReportByIsbn(String isbn) {
		log.info("getReportByIsbn()");
		
		List<ReportDTO> reportList = reportDao.getReportByIsbn(isbn);
		
		return reportList;
	}

}
