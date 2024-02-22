package com.semi.bookrep;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.util.MainUtil;

public class setPagingTest {
	
	
	
	@SuppressWarnings("rawtypes")
	@Test
	public void setPagingTest() {
		
		int testNum = 6;
		
		List<String> testList = new ArrayList<>();
		for(int i = 0; i <12; i++) {
			testList.add("가나다");
		}
		
		List<PageDTO> testResultList = MainUtil.setPaging(testList, testNum);
		
		try {
			System.out.println("됬나?");
			for (int i = 0; i < testResultList.size(); i++) {
				System.out.println(testResultList.get(i).getPageNum());
			}
			
		} catch (Exception e) {
			System.out.println("에러발생");
			e.printStackTrace();
		}
	}
}
