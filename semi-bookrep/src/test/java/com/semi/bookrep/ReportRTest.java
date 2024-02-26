package com.semi.bookrep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.semi.bookrep.dto.CommentDTO;
import com.semi.bookrep.dto.ReportDTO;
import com.semi.bookrep.service.ReportRService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class ReportRTest {
	
	@Autowired
	private ReportRService reportRService;

	@Test
	void getReportDetailByReportIdTest() {
		ReportDTO reportDTO = reportRService.getReportDetailByReportId(4L);
		System.out.println("title: " + reportDTO.getTitle());
		System.out.println("content: " + reportDTO.getContent());
	}
	
//	@Test
//	void setLikeTest() {
//		reportRService.setLike("ing06047", 3L);
//	}
//	
//	@Test
//	void setCommentTest() {
//		reportRService.setComment("ing06047", 3L, "¹º°¡¹º°¡");
//	}
	
	@Test
	void getCommentByReportIdTest() {
		List<CommentDTO> commentList = reportRService.getCommentByReportId(3L);
		for (CommentDTO commentDTO : commentList) {
			System.out.println("email: " + commentDTO.getUserEmail());
			System.out.println("content: " + commentDTO.getContent());
		}
	}
	
	@Test
	void getLikeValueByReportIdTest() {
		System.out.println(reportRService.getLikeValueByReportId(3L));
	}
}
