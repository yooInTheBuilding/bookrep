package com.semi.bookrep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.semi.bookrep.dto.BookDTO;
import com.semi.bookrep.dto.ReportDTO;
import com.semi.bookrep.service.BookService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class BookTest {
	
	@Autowired
	private BookService bookService;

	@Test
	void getReportByIsbnTest() {
		List<ReportDTO> reportList = bookService.getReportByIsbn("isbn어쩌구");
		for (ReportDTO reportDTO : reportList) {
			System.out.println("title: " + reportDTO.getTitle());
			System.out.println("isbn: " + reportDTO.getBookIsbn());
		}
	}
	
	@Test
	void getBookByIsbnTest() {
		BookDTO bookDTO = bookService.getBookByIsbn("isbn어쩌구");
		System.out.println("name: " + bookDTO.getName());
		System.out.println("isbn: " + bookDTO.getIsbn());
	}

}
