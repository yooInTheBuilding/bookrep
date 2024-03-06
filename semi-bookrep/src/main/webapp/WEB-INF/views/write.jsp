<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
<link rel="stylesheet" href="resources/css/write.css">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>
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
	<div class="wrap">

		<br> <br> <br>
		<div class="content">
			<!-- 검색어 입력 폼 -->
			<form action="<c:url value='/book-search' />" method="get"
				accept-charset="UTF-8">
				<div class="form-group">
					<input type="text" id="searchKeyword" name="keyword" class="form-control" required>
					<button type="submit" class="btn btn-info">책 검색</button>
				</div>
			</form>
			<br>
			<hr>
			<h2 class="form-header">독후감 작성</h2>
			<div>
				<input type="text" class="write-input" name="title" placeholder="Book_Name" readonly="readonly"
				value="${not empty book ? book.name : 'No Book Title'}">
			</div>
			<br>
			<form action="save" method="post" accept-charset="UTF-8">
				<input type="hidden" name="userEmail" value="${sessionScope.email}">
				<input type="text" class="write-input" name="title" placeholder="Report_Title" required>
				<input type="text" class="write-input" name="bookIsbn" placeholder="Book_ISBN"
					value="${not empty book ? book.isbn : 'No Book ISBN'}" readonly="readonly">
				<input type="text" class="write-input report-input" name="content" placeholder="Report_Content">
				<input type="checkbox" name="publicBool" checked="checked">Public
				<div class="btn-area">
					<input type="submit" class="btn-write" value="Write" onclick="msg()" required>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		let m = "${msg}";
		if (m !== "") {
			alert(m);
		}
	});
</script>
</html>