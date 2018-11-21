<! DOCTYPE HTML>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/otherUser.css" rel="stylesheet" >
<link href="https://fonts.googleapis.com/css?family=Anton|Montserrat" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vigure: Debate Peacefully</title>
</head>
<body>
	<div class="otherUserPage">
		<div class="otherUserHeader">
			<a href="../main"><div class="mainPage">
			</div></a>
		</div>
		<div class="otherUser">
			<div class="otherUserPicBio">
				<div class="userPic">
						<img src=${otherUser.image} alt="userPic">
				</div>
				<div class="userBio">
					<p>Bio: ${otherUser.bio}</p>
				</div>
			</div>
				<div class="otherUserDetails">
					<div class="otherUserDetailsFormTable">
						<form>
							<table>
								<tr>
									<td>FirstName:&nbsp;&nbsp;&nbsp;&nbsp;${otherUser.firstName}</td>
								</tr>
								<tr>
									<td>LastName:&nbsp;&nbsp;&nbsp;&nbsp;${otherUser.lastName}</td>
								</tr>
								<tr>
									<td>UserName:&nbsp;&nbsp;&nbsp;&nbsp;${otherUser.userName}</td>
								</tr>
								<tr>
									<td>Categories of Interest (comma seperated):&nbsp;&nbsp;&nbsp;&nbsp;${otherUser.categoricalInterest}</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
		</div>
</div>
</body>
</html>