<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="resources/css/update.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="real-out-line">

		<div class="out-line-box">
			<fieldset class="update-frm">

				<h1>modify</h1>

				<form id="userInfo" method="get">
					<p>
					<div class="enter-area">
						<label for="email">이메일</label> <input class="input-1" type="email"
							id="email" name="email" value="${loggedEmail.email}" readonly>
					</div>
					<p>
					<div class="enter-area">
						<label for="name">이름</label> <input class="input-2" type="text"
							id="name" name="name" value="${loggedEmail.name}" readonly>
					</div>
					<p>
					<div class="enter-area">
						<label for="password">패스워드</label> <input class="input-3"
							type="password" id="password" name="password"
							placeholder="패스워드를 입력하세요">
					</div>
					<p>
					<div class="enter-area">
						<label for="password_re">비밀번호 확인</label> <input class="input-4"
							type="password" id="password_re" name="password_re"
							placeholder="패스워드 확인" onblur="password_check()"> <br>
						<span id="password_check"></span>
					</div>

					<p>
					<div class="btn-box">
						<button type="button" onclick="return updateAlert()"
							name="update-btn">update</button>
						<button type="button" onclick="return resignAlert()"
							name="resign-btn">resign</button>
					</div>
					<p>
				</form>
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


const resignAlert = () => {
	var confirmResign = confirm("계정을 삭제하시겠어요?");
	
	if (confirmResign){
		$.ajax({
			type: "get",
			url: "resign",
			data: $("#userInfo").serialize(),
			success: function (response) {
				if (response.success) {
					alert("탈퇴 성공");
					location.href = "home1";
				} else {
					alert("탈퇴 실패");
					location.href = "redirect:/update";
				}
			}
		});
	}
	return true;
}


</script>
</html>