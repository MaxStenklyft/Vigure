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
                    <a href="settings"><div class="accountMain">
                    </div></a>
            </div>
            <div class="titleAndVideos">
                <div class="roomTitle">
                    <h2>Was the moon landing in 1969 real?</h2>
                </div>
                <div class="videoFeeds">
                <div class="userVideo">
                	<video id="localVideo" autoplay/>
				    <script>
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
                <div class="opponentVideo">
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
                                Many people believe the moon landing footage in 1969 was fake because the United States wanted to win the space race. Are you 100% sure the US went to the moon in 1969?
                        </p>
                    </div>

                    <div class="surrenderTime">
                            <button>Surrender Time</button>
                    </div>

                    <div class="endDebate">
                            <button onclick="location.href = 'main';">End Debate</button>
                    </div>
                    
                    <div class="timer">
                    </div>
                </div>
    </div>
    <div class = "timers">
    	<p id="roundCountdown">
    	Time left in round: 
    	<script type="text/javascript">
    	var timeleft = 120;
    	var downloadTimer = setInterval(function(){
    		var current = timeleft - 1;
      		document.getElementById("roundCountdown").innerHTML = "Time left in round: " + current;
      		if(timeleft <= 0)
          		document.getElementById("roundCountdown").innerHTML = "Round Finished!";
    		timeleft = timeleft - 1;
    	},1000);
    	</script>
    	</p>
    	<p id="countdownToDebate">
                	Time remaining until debate:
    		<script>
			// Set the date we're counting down to
			var countDownDate = ${startTime};
			
			if(startTime == null) {
				document.getElementById("countdownToDebate").innerHTML = "Debate Time Not Set";
			}

			// Update the count down every 1 second
			var x = setInterval(function() {

    			// Get todays date and time
    			var now = new Date().getTime();
    
    			// Find the distance between now and the count down date
    			var distance = countDownDate - now;
    
    			// Time calculations for days, hours, minutes and seconds
    			var days = Math.floor(distance / (1000 * 60 * 60 * 24));
    			var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    			var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    			var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
    			// Output the result in an element with id="demo"
    			document.getElementById("countdownToDebate").innerHTML = "Time remaining until debate: " + days + "d " + hours + "h "
    			+ minutes + "m " + seconds + "s ";
    
    			// If the count down is over, write some text 
    			if (distance < 0) {
        			clearInterval(x);
        			document.getElementById("countdownToDebate").innerHTML = "TIME TO DEBATE!";
    			}
			}, 1000);
		</script> 	
    </p>
    </div>
</body>
</html>