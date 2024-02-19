package com.semi.bookrep.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class BookmarkDTO {

	@NonNull
	private String userEmail;
	
	@NonNull
	private String bookIsbn;
	
}
