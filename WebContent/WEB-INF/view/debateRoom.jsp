<! DOCTYPE HTML>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/debateRoom.css" rel="stylesheet" >
<link href="https://fonts.googleapis.com/css?family=Anton|Montserrat" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="${pageContext.request.contextPath}/resources/js/popup.js"></script>
<title>Vigure: c</title>
</head>
<body>
    <div class="debateRoomPage">
            <div class="debateRoomHeader">
                    <a href="\Vigure\settings"><div class="accountMain">
                    </div></a>
            </div>
            <div class="titleAndVideos">
              <div class="roomTitle">
                  <h2>${debate.title }</h2>
              </div>
             <div>
              <video id="Pin" width="320" height="240" autoplay>
					<source src="/Vigure/resources/images/Pineapple.mp4" type="video/mp4">
				</video>
			</div>
              <div class="videoFeeds">
               	 
                <div class="userVideo">
                	<video id="localVideo" autoplay/>
				    <script>
				    	document.getElementById("Pin").play;
					      window.addEventListener("load", function (evt) {
					    	  
					        navigator.getUserMedia({ audio: false, video: true},
					          function(stream) {
					            var video = document.getElementById('localVideo');
					            video.src = window.URL.createObjectURL(stream);
					          },
					          function(err) {
					            console.log("The following error occurred: " + err.name);
					          }
					        );
					      });
				    </script>
                </div>
            </div>
            </div>
                <div class="debateRoomSideBar">

                    <div class="debateDescription">
                            <button onclick="popupDebateDescription()">Description
                            </button>
                    </div>

                    <div class="descriptionPopup" id="debateDescriptionPopup">
                        <p>
                                ${debate.topic}
                        </p>
                    </div>

                    <div class="surrenderTime">
                            <button>Surrender Time</button>
                    </div>

                    <div class="endDebate">
                    	<a href="\Vigure\main">
                            <button>End Debate</button>
                        </a>
                    </div>
                </div>
    </div>
</body>
</html>