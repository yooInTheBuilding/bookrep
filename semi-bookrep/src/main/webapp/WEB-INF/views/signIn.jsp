<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="resources/css/signIn.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="out-line">

		<fieldset class="out-line-box">
			<div class="sign-in-box">

				<h1>로그인</h1>

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
					<div class="login-page-button">
						<button>로그인</button>
			</div> 
				</form>

				<h5>or</h5>

				<a href="/bookrep/find-password">비밀번호 찾기</a>
				<p>
			</div>

		</fieldset>

		<p>
		<fieldset>
			<div class="sign-up-link">
				<p>
					계정이 없나요? <a href="/bookrep/sign-up">회원가입</a> 
				<p>
			</div>
		</fieldset>
	</div>
</body>
</html>