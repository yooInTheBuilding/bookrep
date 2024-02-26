package com.semi.bookrep;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.Charset;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.semi.bookrep.dto.BookDTO;
import com.semi.bookrep.dto.ReportDTO;
import com.semi.bookrep.service.ReportCService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class ReportCTest {
	
	@Autowired
	private ReportCService reportCService;
	
	private RedirectAttributes rttr;
	
	@Test
	void saveBookTest() {
		byte[] array = new byte[13]; // length is bounded by 7
		new Random().nextBytes(array);
		String generatedString = new String(array, Charset.forName("UTF-8"));
		BookDTO bookDTO = new BookDTO();
		bookDTO.setName("책" + generatedString);
		bookDTO.setAuthor("저자" + generatedString);
		bookDTO.setPublisher("출판사" + generatedString);
		bookDTO.setIsbn("isbn" + generatedString);
		bookDTO.setImage("image" + generatedString);
		reportCService.saveBook(bookDTO);
	}
	
	@Test
	void setReportTest() {
		byte[] array = new byte[13]; // length is bounded by 7
		new Random().nextBytes(array);
		String generatedString = new String(array, Charset.forName("UTF-8"));
		HttpSession httpSession = new MockHttpSession();
		httpSession.setAttribute("email", "ing06047");
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setTitle("제목" + generatedString);
		reportDTO.setBookIsbn("isbn어쩌구");
		reportDTO.setContent("내용" + generatedString);
		reportDTO.setUserEmail("ing06047");
		reportDTO.setPublicBool(false);
		String view = reportCService.setReport(httpSession, reportDTO, rttr);
		System.out.println(view);
	}
}
