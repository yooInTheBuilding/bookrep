<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/loggedHeader.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
	<header>
		<div class="header">
			<div class="profile">
				<c:choose>
					<c:when test="${not empty sessionScope.email}">
						<a href="/bookrep/feed/${sessionScope.email}"><i class="fa fa-user-circle-o fa-2x"
							aria-hidden="true"></i></a>
					</c:when>
					<c:otherwise>
						<i class="fa fa-user-circle-o fa-2x" aria-hidden="true"></i>
					</c:otherwise>
				</c:choose>
			</div>
			

			<div class="logo">
				<img src="resources/images/bookrepLogo.png" alt="로고"
					onclick="moveToHome()">
			</div>
			<div class="buttons">
				<div class="search-box">
					<form action="/bookrep/search" method="GET">
						<input type="text" name="keyword" placeholder="검색어를 입력하세요">
						<button type="submit" class="search">search</button>
					</form>
				</div>
				<div class="logout-button">
					<a href="/bookrep/sign-out"><button>로그아웃</button></a>
				</div>
			</div>
		</div>
	</header>
</body>
<script>
	const moveToHome = () => {

		var email = "${sessionScope.email}";
		
		if(email != null) {
			location.href = "/bookrep/home";
		} else {
			location.href = "/bookrep/";
		}
	}
	
	const moveToFeed = () => {
		
		var email1 = "${sessionScope.email}";
		
		if(email1 != null){
			location.href = "/bookrep/feed";
		}
	}
	
	const moveToWrite = () => {
		location.href = "/bookrep/write";
	}
	
</script>

</html>