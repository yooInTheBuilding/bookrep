package com.semi.bookrep.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class FollowDTO {
	
	@NonNull
	private String followerEmail;
	
	@NonNull
	private String followeeEmail;
	
}
