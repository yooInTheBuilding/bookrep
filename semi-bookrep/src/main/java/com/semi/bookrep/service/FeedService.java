package com.semi.bookrep.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.bookrep.dao.ReportDao;
import com.semi.bookrep.dto.PageDTO;
import com.semi.bookrep.dto.ReportDTO;
import com.semi.bookrep.util.MainUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FeedService {
	@Autowired
	ReportDao reportDao;
	
//	MainUtil mainUtil = new MainUtil();

	public List<PageDTO> getReportSummaryById(String userEmail) {
		
		System.out.println(userEmail);

		log.info("getRepostSummarybyId()");
		System.out.println("yo!");
		
		try {
			List<ReportDTO> userReports = reportDao.getReportSummaryById(userEmail);
			System.out.println(userReports);
		} catch (Exception e) {
			log.info("못받아옴");
			e.printStackTrace(); //
		}
		


//		List<PageDTO> reportSummaries = mainUtil.setPaging(userReports, 6);
		
//		return reportSummaries;
		return null;
	}
}
//List<PageDTO> pageDTOList = convertAToB(userReports);

//Map<String, Integer> pmap = new HashMap<String, Integer>();
//pmap.put("pageNum", (pageNum - 1) * listCnt);
//pmap.put("listCnt", listCnt);

//List<ReportDTO> userReports = reportDao.getReportSummaryById(userEmail); // 여기서 요약정보를 가져옴
//log.info("hi?");
//System.out.println(userReports);
//
//// 요약된 정보를 pageDTO 타입으로 변경하기 위한 리스트 선언.
//List<PageDTO> reportSummaries = new ArrayList<>();
//
//// 순차적으로 요약 리스트레 페이징 넘버를 부여하며 넣음
//for (int i = 0; i < userReports.size(); i++) {
//	PageDTO pageDTO = new PageDTO(i, null);
////	pageDTO.setObjectList(userReports.get(i));
//	pageDTO.setPageNum(i);
//	reportSummaries.add(pageDTO);
//}
//
//return reportSummaries;
//return null;

//		List<ReportDTO> userReports = reportDao.getReportSummaryById(userEmail);
//
//        int pageSize = 5; // 한 페이지에 표시할 항목의 수 (원하는 값으로 수정)
//        int totalReports = userReports.size();
//        int totalPages = (int) Math.ceil((double) totalReports / pageSize);
//
//        List<PageDTO> reportSummaries = new ArrayList<>();
//
//        int currentPage = 1; // 초기 페이지 번호 설정
//
//        for (int i = 0; i < totalPages; i++) {
//            PageDTO pageDTO = new PageDTO();
//            int startIdx = i * pageSize;
//            int endIdx = Math.min((i + 1) * pageSize, totalReports);
//
//            // 페이지 번호 설정
//            pageDTO.setPageNum(currentPage);
//
//            // 페이지에 표시될 객체 목록 설정
//            List<Object> objectList = new ArrayList<>();
//            for (int j = startIdx; j < endIdx; j++) {
//                ReportDTO report = userReports.get(j);
//                Object yourObject = new YourObject(
//                    report.getTitle(),
//                    report.getUserEmail(),
//                    report.getLikes()
//                );
//                objectList.add(yourObject);
//            }
//            pageDTO.setObjectList(objectList);
//
//            // 다른 필요한 정보도 매핑
//
//            reportSummaries.add(pageDTO);
//
//            // 다음 페이지를 위해 현재 페이지 번호 증가
//            currentPage++;
//        }
//        return reportSummaries;
//	}

// 아니, dto도 4개 엮여있고 util도 엮여있고 나보고 어떻게 하라고 야발 겁나 복잡하네 하;;;
// 화면에 표기할 사람의 레포트 요약 정보 가져오려면 reportDTO 접근해야되고
// 책정보 가져오려면 reportDTO에는 isbn밖에 없으니깐 bookDTO랑 매칭해야 될테고
// 팔로우 수랑 목록 가져오려면 followDTO에도 접근해야 하고
// 페이징작업 하려면 util 접근해서 페이징 작업하고 그걸 잘 넣야되는데
// pageDTO도 있네 뭐 어떻게 하라는지 큰 그림은 보이는데 큰 그림만 보이네 야발
// 야발 이거 내가 이번주 일요일까지 어떻게든 끝내고 만다.
// 하고 댓글도 해야되네... 으아아아아악