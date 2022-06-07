<%-- 
    Document   : testchat
    Created on : Jun 6, 2022, 10:48:30 PM
    Author     : khuat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Demo websocket</title>
</head>
<body>	
		<h2>Demo WebSocket Chat Room</h2>
		<input id="textMessage" type="text" />
		<input onclick="sendMessage()" value="Send Message" type="button" /> <br/><br/>
		
		<textarea id="textAreaMessage" rows="10" cols="50"></textarea>

		<script type="text/javascript">
			var websocket = new WebSocket("ws://localhost:8080/WebSocketChatServer/chatRoomServer");
				websocket.onopen = function(message) {processOpen(message);};
				websocket.onmessage = function(message) {processMessage(message);};
				websocket.onclose = function(message) {processClose(message);};
				websocket.onerror = function(message) {processError(message);};

			function processOpen(message) {
				textAreaMessage.value += "Server connect... \n";
			}
			function processMessage(message) {
				console.log(message);
				textAreaMessage.value += message.data + " \n";
			}
			function processClose(message) {
				textAreaMessage.value += "Server Disconnect... \n";
			}
			function processError(message) {
				textAreaMessage.value += "Error... " + message +" \n";
			}

			function sendMessage() {
				if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
					websocket.send(textMessage.value);
					textMessage.value = "";
				}
			}

		</script>
</body>
</html>