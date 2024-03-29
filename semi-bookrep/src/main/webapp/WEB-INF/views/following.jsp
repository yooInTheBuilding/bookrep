<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<title>팔로잉 목록</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/search.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/page.css">
</head>
<script type="text/javascript">
	
</script>
<body>
	<c:choose>
		<c:when test="${not empty sessionScope.email}">
			<jsp:include page="loggedHeader.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="header.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>

	<h1 id="search-title">"${email}"님의 팔로잉 목록</h1>
	<div class="container">

		<div class="section">
			<h2>팔로잉</h2>
			<c:if test="${empty followingList}">
				<p>해당 유저의 팔로잉이 존재하지 않습니다</p>
			</c:if>
			<div class="page-container">
				<ul>
					<c:forEach items="${followingList}" var="following">
						<li class="display">
						<a href="/bookrep/feed/${following.email}">
								${following.email} </a>
						<a href="/bookrep/feed/${following.email}">
								${following.name} </a>
						<br>
						<a href="/bookrep/feed/${following.email}">
						 <img src="<%=request.getContextPath()%>/resources/images/${following.image}"></a>
								</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<div class="page">
		<!-- 이전 버튼 -->
		<c:if test="${currentPageNum > 1}">
			<a
				href="?pageNum=${currentPageNum - 1}"
				class="page-link">이전</a>
		</c:if>
		<!-- 다음 버튼 -->
		<c:if test="${currentPageNum * 6 < totalFollowingSize}">
			<a
				href="?pageNum=${currentPageNum + 1}"
				class="page-link">다음</a>
		</c:if>
	</div>
	

</body>
</html>
