<! DOCTYPE HTML>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" >
<link href="https://fonts.googleapis.com/css?family=Anton|Montserrat" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<div class="loginPage">
	<div class="heading">
		<div class="title">
		<h1>Vigure</h1>
		<h3>Debate Peacefully</h3>
		</div>
	</div>
<div class="loginCreds">
	<div class="signInText">
	<p>Sign in to your account to start debating</p>
	</div>
	${error }
	<form method="post"
		action="${pageContext.request.contextPath }/login">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td ><input type="submit" id="signInButton" value="Sign In"></td>
			</tr>
		</table>
	</form>
	<div class="signInAgreement">
			<p>By clicking Sign In, you agree to our License Agreement and have read and acknowledge our Privacy Statement.</p>
	</div>
	<hr>
	<div class="newUser">
		<p>New to Vigure?</p>
		<a>Create an account</a>
	</div>
</div>
</div>
</body>
</html>