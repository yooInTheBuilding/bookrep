package com.semi.bookrep.util;

import java.util.ArrayList;
import java.util.List;

import com.semi.bookrep.dto.PageDTO;

public class MainUtil {
	private static int maxNum=0;
	
	// 매개변수인 maxCnt는  메인 디스플레이에 표시되는 콘텐츠 개수
	@SuppressWarnings("rawtypes")
	public static <T> List<PageDTO> setPaging(List<T> objectList, int maxCnt){
		if (objectList.size() % maxCnt == 0) {
			maxNum = objectList.size() / maxCnt;
		}else {
			maxNum = objectList.size() / maxCnt + 1;
		}
		
		List<PageDTO> pageDTOList = new ArrayList<>();
		
		for(int i=0; i<maxNum; i++) {
			List<T> onePageList = new ArrayList<T>();
			for (int j = maxCnt * i; j < maxCnt * (i + 1); j++) {
				onePageList.add(objectList.get(j));
			}
			PageDTO<T> pageDTO = new PageDTO<T>(i + 1, onePageList);
			pageDTOList.add(pageDTO);
		}
		return pageDTOList;
	}
}