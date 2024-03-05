<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<title>Search Results</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/search.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/feed.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/header.css">
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

	<h1 id="search-title">"${email}"님의 북마크 목록</h1>
	<div class="container">

		<div class="section">
			<h2>Bookmark</h2>
			<c:if test="${empty bookmarkList}">
				<p>No bookmark found.</p>
			</c:if>
			<div class="page-container">
				<ul>
					<c:forEach items="${bookmarkList}" var="book">
						<li class="display">
						<a href="/bookrep/book-detail?isbn=${book.isbn}">
								${book.name} </a>
						<a href="/bookrep/book-detail?isbn=${book.isbn}">
						 <img src="${book.image}"></a>
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
		<c:if test="${currentPageNum * 6 < totalBookSize}">
			<a
				href="?pageNum=${currentPageNum + 1}"
				class="page-link">다음</a>
		</c:if>
	</div>
	

</body>
</html>
