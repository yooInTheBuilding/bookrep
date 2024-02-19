package com.semi.bookrep.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NonNull;

@Data
public class ReportDTO {
	
	private Long id;
	
	@NonNull
	private String userEmail;
	
	@NonNull
	private String bookIsbn;
	
	@NonNull
	private String title;
	
	@NonNull
	private String content;
	
	@NonNull
	private boolean publicBool;
	
	private LocalDateTime time = LocalDateTime.now();
	

}
