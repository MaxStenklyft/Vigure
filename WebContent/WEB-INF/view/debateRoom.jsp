<! DOCTYPE HTML>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/debateRoom.css" rel="stylesheet" >
<link href="https://fonts.googleapis.com/css?family=Anton|Montserrat" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="${pageContext.request.contextPath}/resources/js/popup.js"></script>
<title>Vigure: </title>
</head>
<body>
	<input type="hidden" id="debateRounds" value="${debate.rounds}"/>
	<input type="hidden" id="debateRoomRoundTime" value="${debate.timeInterval}"/>
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
                    <div class = "timers">
    					<p id="roundCountdown">
    					Time left in round: 
    					<script type="text/javascript">
    						var timeleft = document.getElementById("debateRoomRoundTime").value * 60;
    						var downloadTimer = setInterval(function(){
    						var current = timeleft - 1;
      						document.getElementById("roundCountdown").innerHTML = "Time left in round: " + current;
      						if(timeleft <= 0) {
      							document.getElementById("roundCountdown").innerHTML = "Round Finished!";
      							rounds = rounds - 1;
      							timeleft = document.getElementById("debateRoomRoundTime").value * 60;
      							
      							if(rounds % 2 == 0)
      		                		document.getElementById("whichTurn").innerHTML = "WHOSE TURN? INSTIGATOR";
      		                	else
      		                		document.getElementById("whichTurn").innerHTML = "WHOSE TURN? DEFENDANT";
      						}
      						if(rounds == 0) {
      							document.getElementById("whichTurn").innerHTML = "WHOSE TURN? NOBODY'S";
      							document.getElementById("roundCountdown").innerHTML = "Debate Finished!";
  								return;
    						}
    						timeleft = timeleft - 1;
    						},1000);
    					</script>
    					</p>
    				</div>
                    
                </div>
                <div class="debateRoomLeftSide">
                	<div class="role1"><p>DEFENDANT: Top</p></div>
                	<div class="role1"><p>INSTIGATOR: Bottom</p></div>
                </div>
                <div class="whoseTurn">
                	<p id="whichTurn">
                	WHOSE TURN? "
                	<script type="text/javascript">
                	var rounds = document.getElementById("debateRounds").value * 2;
                	if(rounds % 2 == 0)
                		document.getElementById("whichTurn").innerHTML = "WHOSE TURN? INSTIGATOR";
                	else
                		document.getElementById("whichTurn").innerHTML = "WHOSE TURN? DEFENDANT";
                	</script>
                	</p>
                </div>
    </div>
</body>
</html>