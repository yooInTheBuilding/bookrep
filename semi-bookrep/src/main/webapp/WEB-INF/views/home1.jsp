<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<script>
$(function() {
	let m = "${msg}";
	if (m != "") {
		alert(m);
	}
});
</script>
<head>
<meta charset="UTF-8">
<title>로그인 하세요</title>
<style>
body {
	background-color: #f5f5f5;
}
</style>
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
	<div class="mainLogo">
		<img alt="mainLogo" src="resources/images/newFullLogo.png">
	</div>
</body>
</html>