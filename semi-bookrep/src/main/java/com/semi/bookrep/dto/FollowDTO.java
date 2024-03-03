package com.semi.bookrep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowDTO {
	
	
	private String followerEmail;
	

	private String followeeEmail;
	
}
