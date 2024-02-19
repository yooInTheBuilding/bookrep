package com.semi.bookrep.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class BookDTO {

	@NonNull
	private String name;
	
	@NonNull
	private String author;
	
	@NonNull
	private String publisher;
	
	@NonNull
	private String isbn;
	
	@NonNull
	private String image;
	
}
