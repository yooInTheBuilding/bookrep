package com.semi.bookrep.dao;

import java.util.List;
import com.semi.bookrep.dto.ReportDTO;

public interface ReportDao {
	
	void setReport(ReportDTO reportDTO);

	ReportDTO getReportDetailByReportId(Long id);

	void deleteReportByReportId(Long id);

	List<ReportDTO> getReportSummaryById(String userEmail);

}
