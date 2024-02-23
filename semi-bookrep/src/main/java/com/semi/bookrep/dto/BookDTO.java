package com.semi.bookrep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
