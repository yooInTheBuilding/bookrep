package com.semi.bookrep.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NonNull;

@Data
public class CommentDTO {
	
	private Long id;
	
	@NonNull
	private String userEmail;
	
	@NonNull
	private Long reportId;
	
	@NonNull
	private String content;
	
	private LocalDateTime time = LocalDateTime.now();
	
}
