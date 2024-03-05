<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/loggedHeader.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
</head>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous">
	</script>
<body>
	<header>
		<div class="header">
			<div class="profile">
				<c:choose>
					<c:when test="${not empty sessionScope.email}">
						<a href="/bookrep/feed/${sessionScope.email}" id="userImage"></a>
					</c:when>
					<c:otherwise>
						<i class="fa fa-user-circle-o fa-2x" aria-hidden="true"></i>
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="write-button">
				<button onclick="moveToWrite()">Write</button>
			</div>

			<div class="logo">
				<img
					src="<%=request.getContextPath()%>/resources/images/bookrepLogo.png"
					alt="로고" onclick="moveToHome()">
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
	var logggggggggggemail = "${sessionScope.email}";
	var userImage = document.getElementById("userImage");
	$.ajax({
		url : '<%=request.getContextPath()%>/get-image',
		type : 'post', 
		data : {
			email : logggggggggggemail
		},
		success : function(imageAjax) { //컨트롤러에서 넘어온 cnt값을 받는다 
			console.log(imageAjax);
			var imagePath = '<%=request.getContextPath()%>/resources/images/' + imageAjax;
			userImage.innerHTML = '<img src="' + imagePath + '">';
		},
		error : function() {
			alert("에러입니다");
		}
	});
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