<! DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>
<body>

	<h3>Success Page</h3>
	Welcome ${sessionScope.username }
	<br>
	<a href="${pageContext.request.contextPath }/login/logout">Logout</a>

</body>
</html>