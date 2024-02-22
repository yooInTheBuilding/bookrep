package com.semi.bookrep.util;

<<<<<<< Updated upstream
import java.util.ArrayList;
import java.util.List;

import com.semi.bookrep.dto.PageDTO;

public class MainUtil {
	private static int maxNum=0;
	
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
=======
import java.util.List;

import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.dto.UserDTO;

public class MainUtil {

	public static <T> List<PageDTO> setPaging(List<T> objectList, int maxCnt) {
		
		return null;
	}

}
>>>>>>> Stashed changes
