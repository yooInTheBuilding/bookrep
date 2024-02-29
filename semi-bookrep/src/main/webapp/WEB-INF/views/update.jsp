<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/update.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
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

	<div class="real-out-line">

		<div class="out-line-box">
			<fieldset class="update-frm">

				<h1>modify</h1>

				<form id="userInfo" action="resign" method="get">
					<p>
					<div class="enter-area">
						<label class="label1" for="email">이 메 일</label> <input type="email"
							class="input1" id="email" name="email" value="${user.email}"
							readonly>
					</div>
					<p>
					<div class="enter-area">
						<label class="label2" for="name">이 름</label> <input class="input2" type="text"
							id="name" name="name" value="${user.name}">
					</div>
					<p>
					<div class="enter-area">
						<label class="label3" for="password">패 스 워 드</label> <input class="input3"
							type="password" id="password" name="password"
							placeholder="패스워드를 입력하세요">
					</div>
					<p>
					<div class="enter-area">
						<label class="label4" for="password_re">비밀번호 확인</label> <input class="input4"
							type="password" id="password_re" name="password_re"
							placeholder="패스워드 확인" onblur="password_check()"> <br>
						<span id="password_check"></span>
					</div>
				</form>

					<p>
					<div class="btn-box">
						<button type="button" onclick="return updateAlert()"
							name="update-btn">update</button>
						<button onclick="resignAlert()" name="resign-btn">resign</button>
					</div>
					<p>
			</fieldset>
		</div>
	</div>
</body>
<script>
const password_check = () => {
	const password = document.getElementById("password").value;
    const password_re = document.getElementById("password_re").value;
    
    const pwCheck = document.getElementById("password_check");

    if (password == password_re) {
    	pwCheck.innerHTML = "패스워드 일치가 일치합니다.";
    	pwCheck.style.color = "green";
    } else {
    	pwCheck.innerHTML = "다시 확인하세요.";
    	pwCheck.style.color = "red";
    }
}

function resignAlert() {
	
	var confirmResign = confirm("계정을 삭제하시겠어요?");
	
	if(confirmResign){
		document.getElementById("userInfo").submit();
		alert("회원탈퇴 성공");
	} else {
		location.reload();
	}
}

function updateAlert() {
	
	var confirmUpdate = confirm("정보를 수정하시겠어요?");
	
	if(confirmUpdate){
		document.getElementById("userInfo").action = "update";
		document.getElementById("userInfo").submit();
		alert("회원정보 수정 완료")
	}
}
</script>
</html>