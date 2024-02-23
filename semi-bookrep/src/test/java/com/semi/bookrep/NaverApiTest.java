package com.semi.bookrep;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.semi.bookrep.dto.BookDTO;
import com.semi.bookrep.service.ReportCService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class NaverApiTest {

	@Autowired
	private ReportCService reportCService;
	
	@Test
	public void test() throws IOException, InterruptedException {
		List<BookDTO> bookList = reportCService.getBookByAPI("½Å");
		for (BookDTO bookDTO : bookList) {
			System.out.println("name: " + bookDTO.getName());
			System.out.println("author: " + bookDTO.getAuthor());
			System.out.println("publisher: " + bookDTO.getPublisher());
			System.out.println("isbn: " + bookDTO.getIsbn());
			System.out.println("image: " + bookDTO.getImage());
		}
	}
}
