<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/signIn.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="out-line">

		<fieldset class="out-line-box">
			<div class="sign-in-box">

				<h1>SignIn</h1>

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
						<button>Login</button>
			</div>
				</form>

				<h5>or</h5>

				<a href="/bookrep/find-password">Find Password</a>
				<p>
			</div>

		</fieldset>

		<p>
		<fieldset>
			<div class="sign-up-link">
				<p>
					Don't have an account? <a href="/bookrep/find-password">Sign Up</a>
				<p>
			</div>
		</fieldset>
	</div>
</body>
</html>