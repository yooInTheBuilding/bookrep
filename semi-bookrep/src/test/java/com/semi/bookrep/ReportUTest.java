package com.semi.bookrep;

import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;

import com.semi.bookrep.dto.ReportDTO;
import com.semi.bookrep.service.ReportUService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class ReportUTest {
	
	@Autowired
	private ReportUService reportUService;


//	@Test
//	void isOwnerTest() {
//		HttpSession session = new MockHttpSession();
//		session.setAttribute("email", "ing06047");
//		ReportDTO reportDTO = new ReportDTO();
//		reportDTO.setUserEmail("ing06047");
//		reportDTO.setContent("览");
//		reportDTO.setBookIsbn("isbn绢录备");
//		reportDTO.setTitle("力格力格");
//		reportDTO.setPublicBool(false);
//		
//		String view = reportUService.isOwner(session, reportDTO);
//		System.out.println(view);
//	}
	
	@Test
	void applyReportUpdateTest() {
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setId(4L);
		reportDTO.setUserEmail("ing06047");
		reportDTO.setContent("览");
		reportDTO.setBookIsbn("isbn绢录备");
		reportDTO.setTitle("力格力格");
		reportDTO.setPublicBool(false);
		
		reportUService.applyReportUpdate(reportDTO);
	}

}
