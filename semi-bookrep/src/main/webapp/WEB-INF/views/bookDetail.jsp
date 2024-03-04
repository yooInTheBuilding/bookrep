<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/page.css">
<link rel="stylesheet" href="resources/css/bookDetail.css">
</head>
<body>
   <c:choose>
		<c:when test="${not empty sessionScope.email}">
			<jsp:include page="loggedHeader.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="header.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
   <div id="total-body">
      <!-- 여기에 로그인 여부 확인 하는 c:if문 넣어야됨 -->
      <!-- 책이미지 -->
      <div id="book" class="image-container">
         <img src="${book.image}" alt="Book Image">
         <div class="overlay">
            <c:choose>
               <c:when test="${isBookmark}">
                  <img alt="북마크O" src="../resources/images/bookmark_icon_black.png">
               </c:when>
               <c:otherwise>
                  <img alt="북마크X" src="../resources/images/bookmark_icon_blank.png">
               </c:otherwise>
            </c:choose>
            <p>${book.name}</p>
            <p>${book.author}</p>
            <p>${book.publisher}</p>
         </div>
      </div>
      <!-- 독후감리스트 -->
      <div id="report">
         <c:if test="${not empty reportList}">
            <!-- 현재 페이지 설정 -->
            <c:choose>
               <c:when test="${not empty param.pageNum}">
                  <c:set var="currentPageNum" value="${param.pageNum}" />
               </c:when>
               <c:otherwise>
                  <c:choose>
                     <c:when test="${not empty reportList}">
                        <c:set var="currentPageNum" value="${reportList[0].pageNum}" />
                     </c:when>
                  </c:choose>
               </c:otherwise>
            </c:choose>

            <!-- 현재 페이지 번호와 일치하는 독후감 등을 출력하는 부분 -->
            <c:if test="${not empty reportList}">
               <c:forEach var="page" items="${reportList}">
                  <c:if test="${page.pageNum eq currentPageNum}">
                     <div id="report-container">
                        <c:forEach var="report" items="${page.reportList}">
                           <a href="/reportDetail?id=${report.id}" target="_blank">${report.title}</a>
                           <p>${report.userEmail}</p>
                           <p>${report.time}</p>
                        </c:forEach>
                     </div>
                  </c:if>
               </c:forEach>
            </c:if>

            <div class="page">
               <!-- 처음 버튼 -->
               <a href="?pageNum=1" class="page-link">|◀</a>

               <!-- 이전 버튼 -->
               <c:if test="${currentPageNum > 3}">
                  <a href="?pageNum=${currentPageNum - 5}" class="page-link">이전</a>
               </c:if>

               <!-- 페이지 번호 5개씩 표시 -->
               <c:forEach var="i"
                  begin="${currentPageNum - 2 > 0 ? currentPageNum - 2 : 1}"
                  end="${currentPageNum + 2 < reportList.size() ? currentPageNum + 2 : reportList.size()}">
                  <c:choose>
                     <c:when test="${i eq currentPageNum}">
                        <span class="page-link">${i}</span>
                     </c:when>
                     <c:otherwise>
                        <a href="?pageNum=${i}" class="page-link">${i}</a>
                     </c:otherwise>
                  </c:choose>
               </c:forEach>

               <!-- 다음 버튼 -->
               <c:if test="${currentPageNum + 2 < reportList.size()}">
                  <a href="?pageNum=${currentPageNum + 3}" class="page-link">다음</a>
               </c:if>

               <!-- 마지막 버튼 -->
               <a href="?pageNum=${reportList.size()}" class="page-link">▶|</a>
            </div>
         </c:if>
      </div>
   </div>
</body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        // 북마크 이미지 클릭 이벤트 처리
        $("#bookmark-icon").click(function() {
            // 현재 북마크 상태 확인
            var isCurrentlyBookmarked = ${isBookmark};

            // AJAX를 사용하여 서버에 북마크 상태 업데이트 요청
            $.ajax({
                type: "POST",
                url: "/bookmark",
                data: {isbn: "${book.isbn}"},
                success: function(response) {
                    // 서버에서 성공적으로 응답받으면 클라이언트에서 북마크 상태 업데이트
                    if (isCurrentlyBookmarked) {
                        $("#bookmark-icon").attr("src", "../resources/images/bookmark_icon_blank.png");
                    } else {
                        $("#bookmark-icon").attr("src", "../resources/images/bookmark_icon_black.png");
                    }

                    // 북마크 상태 업데이트 후, isBookmark 변수 업데이트
                    ${isBookmark} = !isCurrentlyBookmarked;
                },
                error: function(xhr, status, error) {
                    // 에러 처리
                    console.error("Error updating bookmark status:", error);
                }
            });
        });
    });
</script>
</html>