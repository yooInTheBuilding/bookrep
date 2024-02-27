<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/findPassword.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="out-line">

		<fieldset class="out-line-box">
			<div class="findPw-box">

				<h1>로그인에 문제가 있나요?</h1>
<h5>가입 당시 입력한 이메일과 이름으로 </h5> <br> <h5> 비밀번호를 찾을 수 있습니다.</h5>

				<form action="/bookrep/sign-in" method="post">
					<p>
					<div class="int-area">
						<input type="text" name="email" id="email" autocomplete="off"
							placeholder="Email" required>
					</div>

					<p>
					<div class="int-area">
						<input type="password" name="password" id="password"
							autocomplete="off" placeholder="password" required>
					</div>

					<p>
					<div class="findPw-page-button">
						<button>비밀번호 찾기</button>
			</div> 
				</form>

				<h5>or</h5>

				<a href="/bookrep/sign-up">create new Account</a>
				<p>
			</div>

		</fieldset>

		<p>
		<fieldset>
			<div class="sign-up-link">
				<p>
					<a href="/bookrep/sign-in">back to signIn</a>
				<p>
			</div>
		</fieldset>
	</div>
</body>
</html>