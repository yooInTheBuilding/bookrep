package com.semi.bookrep.dao;

import java.util.List;

import com.semi.bookrep.dto.ReportDTO;

public interface ReportDao {

	List<ReportDTO> getReportSummaryById(String userEmail);

}
