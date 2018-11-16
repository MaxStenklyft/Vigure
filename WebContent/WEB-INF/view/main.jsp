<! DOCTYPE HTML>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
<link href="https://fonts.googleapis.com/css?family=Anton|Montserrat" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="${pageContext.request.contextPath}/resources/js/popup.js"></script>
<title>Vigure: Main Page</title>
</head>
<body>
    <div class="mainPage">
            <div class="mainHeader">
                <a href="settings"><div class="accountMain">
                </div></a>
            </div>
            <div class="createAndSearch">
                <div class="searchUsers">
                    <form>
                        <table>
                                <tr>
                                    <td>Search Users: </td>
                                    <td><input type="text" name="users"></td>
                                </tr>
                        </table>
                    </form>
                </div>
                <div class="">
                	<table>
                                <tr>
                                	${errors}
                                </tr>
                    </table>
                </div>
                <div class="createDebateRoom">
                        <div class="popupDebateRoom" onclick="popupDebateRoom()">Create Debate Room
                        </div>
                </div>
                <div class="createPopup" id="debatePopup">
                	<form method="post" action="${pageContext.request.contextPath }/main/sendDebateRequest">
                        <table>
                                <tr>
                                    <td>Room Title:</td>
                                    <td><input type="text" name="roomTitle"></td>
                                </tr>
                                <tr>
                                    <td>Debate Topic:</td>
                                    <td><input type="text" name="debateTopic"></td>
                                </tr>
                                <tr>
                                    <td>Opponent:</td>
                                    <td><input type="text" name="opponent"></td>
                                </tr>
                                <tr>
                                    <td>Scheduled Time:</td>
                                    <td><input type="datetime-local" name="scheduledTime"></td>
                                </tr>
                                <tr>
                                    <td>Speaking Interval:</td>
                                    <td><input type="text" name="speakingInterval"></td>
                                </tr>
                                <tr>
                                    <td>Rounds:</td>
                                    <td><input type="text" name="rounds"></td>
                                </tr>
                        </table>
                        <input type="submit"/>
                	</form>
                </div>
            </div>
            <div class="invitations">
                <div class="invitationHeading">
                    <p>Accept/Reject Invitations</p>
                </div>
                
                <div class="invitationFromUsers">
                    <div class="userInvitation">
                    <a href="login">
                        <h1>R</h1>
                    </a>
                    </div>
                </div>

            </div>
    </div>
</body>
</html>