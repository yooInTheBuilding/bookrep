
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/header.css">
  <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
  />
</head>
<body>
	<div class="header">
		<div class="profile">
		<i class="fa fa-user-circle-o fa-2x" aria-hidden="true"></i>
			<!-- <img src="user-profile.jpg" alt="프로필 사진"> -->
		</div>
		<div class="logo">
			<img src="resources/images/bookrepLogo.png" alt="로고">
		</div>
		<div class="buttons">
		<div class="search-box">
			<form action="/search" method="GET">
				<input type="text" name="query" placeholder="검색어를 입력하세요">
				<button type="submit" class="search">search</button>
			</form>
		</div>
			
			<button onclick="return moveToSignIn()">로그인</button>
		</div>
	</div>
</body>

<script>
	function moveToSignIn() {
	window.location.href = "signIn.jsp"		
	}
</script>

</html>