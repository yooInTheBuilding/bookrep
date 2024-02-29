<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feed</title>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<h2>Report Summary</h2>

	<div>ListCnt : ${sessionItems.size()}</div>
	<div>UserEmail: ${userEmail}</div>
	<div>
		<img src="${userImage}" alt="UserImage" width="200"
									height="300">
	</div>
	<div>PostCnt: ${reportValue}</div>


	<c:if test="${isCurrentUser}">
		<p>Follower Count: ${followerCnt}</p>
		<p>Following Count: ${followingCnt}</p>
		<button>Modifying</button>
		<a href="bookrep/bookmark/${userEmail}">북마크</a>
	</c:if>
	<c:if test="${not isCurrentUser}">
		<button>Follow</button>
	</c:if>

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

	<!-- 특정 페이지 번호에 해당하는 독후감만 출력되는 부분 -->
	<div id="report-container">
		<!-- 현재 페이지 번호와 일치하는 독후감 등을 출력하는 부분 -->
		<c:if test="${not empty sessionItems}">
			<c:forEach var="page" items="${sessionItems}">
				<c:if test="${page.pageNum eq currentPageNum}">
					<c:forEach var="report" items="${page.objectList}">
						<div>
							<img src="${report.image}" alt="Book Image" width="200"
									height="300">
							<p>${report.report.title}</p>
							<p>${report.report.userEmail}</p>
							<p>${report.report.content}</p>
						</div>
					</c:forEach>
				</c:if>
			</c:forEach>
		</c:if>
	</div>

	<!-- 페이지 번호를 입력하여 해당 페이지로 이동하는 링크 생성 -->
	<c:if test="${not empty sessionItems}">
		<c:forEach var="page" items="${sessionItems}">
			<a href="<%=request.getContextPath()%>/feed/${userEmail}?pageNum=${page.pageNum}"
				class="page-link">${page.pageNum}</a>
		</c:forEach>
	</c:if>

</body>

<script type="text/javascript">

</script>
</html>