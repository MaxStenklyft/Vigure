<! DOCTYPE HTML>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/settings.css" rel="stylesheet" >
<link href="https://fonts.googleapis.com/css?family=Anton|Montserrat" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="${pageContext.request.contextPath}/resources/js/popup.js"></script>
<title>Vigure: Settings</title>
</head>
<body>
    <div class="settingsPage">
            <div class="settingsHeader">
                <a href="main"><div class="mainPage">
                </div></a>
            </div>
            <div class="settings">
                <div class="settingsPicBio">
                    <div class="profilePic">
                            <img src="resources/images/account.png" alt="profilePic">
                    </div>
                        <form method="post" action="${pageContext.request.contextPath }/signup">
                            <table>
                                <tr>
                                    <td>Change Profile Picture:</td>
                                    <td><input id="image" type="file" name="profile_photo" placeholder="Photo" required="" capture></td>
                                </tr>
                                <tr>
                                        <td>Brief Biography:</td>
                                        <td><input type="text" name="bio"></td>
                                    </tr>
                            </table>
                        </form>
                </div>
                    <div class="settingsForm">
                        <div class="settingsFormTable">
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
                                        <td>Categories of Interest (comma seperated):</td>
                                        <td><input type="text" name="COI"></td>
                                    </tr>
                                </table>
                                <a href="settings" class="updateButton">
                                    <p>Update Account</p>
                                </a>
                            </form>
                        </div>
                    </div>
            </div>
    </div>
</body>
</html>