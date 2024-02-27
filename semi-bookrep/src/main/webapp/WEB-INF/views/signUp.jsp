<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/signUp.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="out-line">
		<fieldset class="out-line-box">
			<div class="sign-in-box">

				<h1>SignUp</h1>

				<form action="/bookrep/sign-up" method="post">
					<p>
					<div class="int-area">
						<input type="text" name="email" id="email" autocomplete="off"
							placeholder="email" size="10" required>
						<input class="email-check" type="button"
							value="중복확인" onclick="emailCheck()">
					</div>

					<p>
					<div class="int-area">
						<input type="text" name="name" id="name" autocomplete="off"
							placeholder="name" required>
					</div>

					<p>
					<div class="int-area">
						<input type="password" name="password" id="password"
							autocomplete="off" placeholder="password" required>
					</div>

					<p>
					<div class="signUp-page-button">
						<button>SignUp</button>
					</div>
				</form>

			</div>

		</fieldset>

		<p>
		<fieldset>
			<div class="sign-up-link">
				<p>
					Already have an account? <a href="/bookrep/sign-in">Sign In</a>
				<p>
			</div>
		</fieldset>
	</div>
</body>
<script>

</script>
</html>