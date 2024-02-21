package com.semi.bookrep.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserDTO {
	
	@NonNull
	private String email;
	
	@NonNull
	private String password;
	
	@NonNull
	private String name;
	
	
	private String image;
	
}
