<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<! DOCTYPE HTML>

<html>

<head>
<link href="${pageContext.request.contextPath}/resources/css/createAccount.css" rel="stylesheet" >
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
	<p>Create an account and start debating</p>
	</div>
	${error }
	<form method="post" action="${pageContext.request.contextPath }/login">
		<table>
			<tr>
					<td>Email:</td>
					<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Brief Bio:</td>
				<td><input type="text" name="bio"></td>
			</tr>
			<tr>
				<td>Categories of Interest (Comma Seperated):</td>
				<td><input type="text" name="COI"></td>
			</tr>
			<tr>
				<div class="uploadPic">
						<a href="main">Upload Profile Picture</a>
				</div>
			</tr>
		</table>
		<div class="signIn">
			<a href="main">CREATE ACCOUNT</a>
		</div>
	</form>
	<div class="signInAgreement">
			<p>By clicking Create Account, you agree to our License Agreement and have read and acknowledge our Privacy Statement.</p>
	</div>
</div>
</div>
</body>

</html>