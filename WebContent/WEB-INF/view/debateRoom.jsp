<! DOCTYPE HTML>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/debateRoom.css" rel="stylesheet" >
<link href="https://fonts.googleapis.com/css?family=Anton|Montserrat" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="${pageContext.request.contextPath}/resources/js/popup.js"></script>
<title>Vigure: Debate Room</title>
</head>
<body>
    <div class="debateRoomPage">
            <div class="debateRoomHeader">
                    <a href="login"><div class="accountMain">
                    </div></a>
                </div>
                <div class="titleAndVideos">
                    <div class="roomTitle">
                        <h2>Was the moon landing in 1969 real?</h2>
                    </div>
                    <div class="videoFeeds">
                    <div class="userVideo">
                    	<video id="vid1" autoplay playsinline></video>
                    </div>
                    <div class="opponentVideo">
                    	<video id="vid2" autoplay playsinline></video>
                    </div>
                </div>
                
                <div id="buttons">
    				<button id="snap">Snap</button><span> then </span><button id="send">Send</button>
    				<span> or </span>
    				<button id="snapAndSend">Snap &amp; Send</button>
  				</div>

                </div>
                <div class="debateRoomSideBar">

                    <div class="debateDescription">
                            <div class="popupDebateDescription" onclick="popupDebateDescription()">Description
                            </div>
                    </div>

                    <div class="descriptionPopup" id="debateDescriptionPopup">
                        <p>
                                Many people believe the moon landing footage in 1969 was fake because the United States wanted to win the space race. Are you 100% sure the US went to the moon in 1969?
                        </p>
                    </div>

                    <div class="surrenderTime">
                            <button>Surrender Time</button>
                    </div>

                    <div class="endDebate">
                            <button onclick="location.href = 'main';">End Debate</button>
                    </div>
                </div>
           
  		   <script src="https://webrtc.github.io/adapter/adapter-latest.js"></script>
  		   <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>     
    </div>
</body>
</html>