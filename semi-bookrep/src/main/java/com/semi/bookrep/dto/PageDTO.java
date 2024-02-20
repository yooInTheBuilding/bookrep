package com.semi.bookrep.dto;

import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
public class PageDTO {
	@NonNull
	private int pageNum;
	
	@NonNull
	private List<Object> objectList;
}
