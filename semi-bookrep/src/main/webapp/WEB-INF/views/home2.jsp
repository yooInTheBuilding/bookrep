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
<link rel="stylesheet" href="resources/css/home2.css">
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

	<!-- 현재 페이지 설정 -->
	<c:choose>
		<c:when test="${not empty param.pageNum}">
			<c:set var="currentPageNum" value="${param.pageNum}" />
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${not empty sessionItems}">
					<c:set var="currentPageNum" value="${sessionItems[0].pageNum}" />
				</c:when>
			</c:choose>
		</c:otherwise>
	</c:choose>

	<!-- 현재 페이지 번호와 일치하는 독후감 등을 출력하는 부분 -->
	<c:if test="${not empty sessionItems}">
		<c:forEach var="page" items="${sessionItems}">
			<c:if test="${page.pageNum eq currentPageNum}">
				<div id="report-container">
					<c:forEach var="report" items="${page.objectList}">
						<fieldset>
							<div class="report-container">
								<a href="/bookrep/feed/${report.userEmail}"><p>${report.userEmail}</p></a>
								<div class="report-detail"
									onclick="moveToReportDetail(${report.id})">
									<p>${report.title}</p>
									<p>${report.content}</p>
								</div>
							</div>
						</fieldset>
					</c:forEach>
				</div>
			</c:if>
		</c:forEach>
	</c:if>

	<c:if test="${not empty sessionItems}">

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
				end="${currentPageNum + 2 < sessionItems.size() ? currentPageNum + 2 : sessionItems.size()}">
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
			<c:if test="${currentPageNum + 2 < sessionItems.size()}">
				<a href="?pageNum=${currentPageNum + 3}" class="page-link">다음</a>
			</c:if>

			<!-- 마지막 버튼 -->
			<a href="?pageNum=${sessionItems.size()}" class="page-link">▶|</a>
		</div>
	</c:if>
</body>
<script type="text/javascript">
function moveToReportDetail(reportId) {
	location.href = "/bookrep/report-detail?id=" + reportId;
}
</script>
</html>