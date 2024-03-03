package com.semi.bookrep;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.semi.bookrep.dto.BookDTO;
import com.semi.bookrep.service.BookService;
import com.semi.bookrep.service.BookmarkService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class BookmarkTest {
	
	@Autowired
	private BookmarkService bookmarkService;
	
	@Autowired
	private BookService bookService;

	@Test
	void isBookmarkTest() {
		HttpSession session = new MockHttpSession();
		session.setAttribute("email", "ing06047");
		
		boolean isBookmark = bookmarkService.isBookmark(session, "isbn어쩌구");
		System.out.println(isBookmark);
	}
	
	@Test
	void setBookmarkTest() {
		HttpSession session = new MockHttpSession();
		session.setAttribute("email", "ing06047");
		
		bookmarkService.setBookmark(session, "isbn어쩌구");
	}
	
	@Test
	void getBookmarkByEmailTest() {
		List<BookDTO> bookList = bookmarkService.getBookmarkByEmail("ing06047");
		for (BookDTO bookDTO : bookList) {
			System.out.println("name: " + bookDTO.getName());
			System.out.println("isbn: " + bookDTO.getIsbn());
			System.out.println("author: " + bookDTO.getAuthor());
		}
	}
	
	@Test
	void removeBookmarkTest() {
		HttpSession session = new MockHttpSession();
		session.setAttribute("email", "ing06047");
		bookmarkService.removeBookmark(session, "isbn어쩌구");
	}

}
