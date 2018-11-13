<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<! DOCTYPE HTML>

<html>

<head>
<link href="${pageContext.request.contextPath}/resources/css/createAccount.css" rel="stylesheet" >
<link href="https://fonts.googleapis.com/css?family=Anton|Montserrat" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vigure: SignUp</title>
</head>

<body>
<div class="signUpPage">
	<div class="goToSignIn">
		<p class="goSignInText">Already have a Vigure account?</p>
		<a href="login" class="goSignInButton">
			<p>Sign In</p>
		</a>
	</div>
	<div class="heading">
		<div class="title">
		<h1>Vigure</h1>
		<h3>Debate Peacefully</h3>
		</div>
	</div>
<div class="signUpCreds">
	<div class="signUpText">
	<p>Create an account and start debating</p>
	</div>
	<p id = "mandatoryField">* denotes that the field is required</p>
	${error }
	<form method="post" action="${pageContext.request.contextPath }/login">
		<table>
			<tr>
					<td>*Email:</td>
					<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>*Username:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>*Password:</td>
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
				<td>Upload Profile Picture (Optional):</td>
				<td><input id="image" type="file" name="profile_photo" placeholder="Photo" required="" capture></td>
			</tr>
		</table>
		<a href="main" class="signUp">
			<p>CREATE ACCOUNT</p>
		</a>
	</form>
	<div class="signUpAgreement">
			<p>By clicking Create Account, you agree to our License Agreement and have read and acknowledge our Privacy Statement.</p>
	</div>
</div>
</div>
</body>

</html>