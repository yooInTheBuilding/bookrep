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

	<h1 id="search-title">Search Results for "${keyword}"</h1>
	<div class="container">

		<div class="section">
			<h2>Users</h2>
			<c:if test="${empty userList}">
				<p>No users found.</p>
			</c:if>
			<div class="page-container">
				<ul>
					<c:forEach items="${userList}" var="user">
						<li class="display">
						<a href="feed/${user.email}">
								${user.name} </a>
								<br>
						<a href="feed/${user.email}">
								<img src="<%=request.getContextPath()%>/resources/images/${user.image}"> </a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<div class="page">
		<!-- 이전 버튼 -->
		<c:if test="${currentUserPageNum > 1}">
			<a
				href="?keyword=${keyword}&userPageNum=${currentUserPageNum - 1}&bookPageNum=${currentBookPageNum}"
				class="page-link">이전</a>
		</c:if>
		<!-- 다음 버튼 -->
		<c:if test="${currentUserPageNum * 6 < totalUserSize}">
			<a
				href="?keyword=${keyword}&userPageNum=${currentUserPageNum + 1}&bookPageNum=${currentBookPageNum}"
				class="page-link">다음</a>
		</c:if>
	</div>
	<div class="container">
		<div class="section">
			<h2>Books</h2>
			<c:if test="${empty bookList}">
				<p>No books found.</p>
			</c:if>
			<div class="page-container">
				<ul>
					<c:forEach items="${bookList}" var="book">
						<li class="display">
							<a href="book-detail?isbn=${book.isbn}">
								${book.name} </a>
								<br>
							<a href="book-detail?isbn=${book.isbn}">
								<img src="${book.image}"> </a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<div class="page">
		<!-- 이전 버튼 -->
		<c:if test="${currentBookPageNum > 1}">
			<a
				href="?keyword=${keyword}&userPageNum=${currentUserPageNum}&bookPageNum=${currentBookPageNum - 1}"
				class="page-link">이전</a>
		</c:if>
		<!-- 다음 버튼 -->
		<c:if test="${currentBookPageNum * 6 < totalBookSize}">
			<a
				href="?keyword=${keyword}&userPageNum=${currentUserPageNum}&bookPageNum=${currentBookPageNum + 1}"
				class="page-link">다음</a>
		</c:if>
	</div>

</body>
</html>
