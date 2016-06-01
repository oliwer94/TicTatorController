var websocket;
function startGame(gameId, ip) {
	$('#loadingIcon').remove();
	$('#loadingText').remove();
	$('#gameInfo').append('<div id="gameStarted" class="alert alert-info"><strong>Game started!</strong></div>');
	$('#gameId').val(gameId);
	websocket = new WebSocket("ws://" + ip
			+ ":8080/TicTatorGame/gameServerEndpoint/" + gameId
			+ "/" + $('#username').val());
	websocket.onmessage = function processMessage(message) {
		console.log(message.data);
		checkStatus(message);
		try {
			var data = JSON.parse(message.data)["board"];

			for (var i = 0; i < data.length; i++) {
				if (data[i] === "X") {
					document.getElementById("cell_" + i).style.backgroundColor = "red";
				} else if (data[i] === "O")
					document.getElementById("cell_" + i).style.backgroundColor = "blue";
				else
					console.log(data[i]);
			}
		} catch (e) {
			// freedom
		}
	}
}

function checkStatus(message){
	if(message.data == "You are winner!") {
		$('#gameStarted').remove();
		$("#gameInfo").append('<div class="alert alert-success"><strong>Success!</strong> You won the game!</div>');
		var replayBtn = $('<button type="submit" class="btn btn-lg btn-primary center-block">Play again</button>');
        $("#replay").append(replayBtn);
	}
	if(message.data == "You are lose!") {
		$('#gameStarted').remove();
		$("#gameInfo").append('<div class="alert alert-danger"><strong>Bad!</strong> You lost the game!</div>');
		var replayBtn = $('<button type="submit" class="btn btn-lg btn-primary center-block">Play again</button>');
        $("#replay").append(replayBtn);
	}
	if(message.data == "Draw.") {
		$('#gameStarted').remove();
		$("#gameInfo").append('<div class="alert alert-warning"><strong>Its a tie!</strong> No one wins!</div>');
		var replayBtn = $('<button type="submit" class="btn btn-lg btn-primary center-block">Play again</button>');
        $("#replay").append(replayBtn);
	}
}

function getMyJson() {
	$.ajax({
		type : "GET",
		url : contextId.value + "/user/getGame",
		dataType : "json",
		success : function(data) {
			console.log("Game starting...");
			console.log(data);
			startGame(data.gameID, data.ip);
		},
		error : function() {
			setTimeout(function() {
				getMyJson();
			}, 5000)
		}
	});
}

$(document).ready(function() {
	getMyJson();
});

$('.square').click(
		function() {
			websocket.send(gameId.value + '&' + username.value + '&'
					+ (this.id).substring(5));
		});
