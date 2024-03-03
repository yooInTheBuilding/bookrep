package com.semi.bookrep;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.semi.bookrep.service.ReportDService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class ReportDTest {
	
	@Autowired
	private ReportDService reportDService;

	@Test
	void deleteReportByReportIdTest() {
		reportDService.deleteReportByReportId(3L);
	}

}
