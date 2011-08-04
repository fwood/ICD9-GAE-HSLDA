var sendReq = getXmlHttpRequestObject();
			// Function for initializating the page.
			function start() {
				// Set the focus to the text entry box.
				document.getElementById('icd9_code').focus();
			}		
			// Gets the browser specific XmlHttpRequest Object
			function getXmlHttpRequestObject() {
				if (window.XMLHttpRequest) {
					return new XMLHttpRequest();
				} else if(window.ActiveXObject) {
					return new ActiveXObject("Microsoft.XMLHTTP");
				} else {
					alert("Status: Cound not create XmlHttpRequest Object.  Consider upgrading your browser.");
				}
			}
			
			
			// Add a message to the chat server.
			function lookup() {
				if(document.getElementById('icd9_code').value == '') {
					alert("You have not entered a code.");
					return;
				}
				if (sendReq.readyState == 4 || sendReq.readyState == 0) {
					sendReq.open("GET", 'rest/icd9/' + document.getElementById('icd9_code').value, true);
					sendReq.setRequestHeader('Accept','application/json');
					sendReq.onreadystatechange = handleCodeText; 
					//var param = 'message=' + document.getElementById('txt_message').value;
					//param += '&name=Ryan Smith';
					//param += '&chat=1';
					//sendReq.send(param);
					sendReq.send(null);
					//document.getElementById('txt_message').value = '';
				}							
				
			}
			
			function handleCodeText() {
				if (sendReq.readyState == 4) {
					// Get a reference to our chat container div for easy access
					var chat_div = document.getElementById('div_code_text');
					// Get the AJAX response and run the JavaScript evaluation
					// function
					// on it to turn it into a useable object. Notice since we
					// are passing
					// in the JSON value as a string we need to wrap it in
					// parentheses
					if(sendReq.responseText == '') {
						var currentHTML = chat_div.innerHTML;
						chat_div.innerHTML = 'No such code in database. <br />';
						chat_div.innerHTML +=currentHTML;
						chat_div.scrollTop = 0;
						return;
					}
					var response = eval("(" + sendReq.responseText + ")");
					var currentHTML = chat_div.innerHTML;
                    chat_div.innerHTML = response.code;
                    chat_div.innerHTML += '&nbsp;&nbsp;';
                    chat_div.innerHTML += response.text + '<br />';
                    chat_div.innerHTML +=currentHTML;
                        chat_div.scrollTop = 0;//chat_div.scrollHeight;
                        
					//for(i=0;i < response.messages.message.length; i++) {
					//	chat_div.innerHTML += response.messages.message[i].code;
					//	chat_div.innerHTML += '&nbsp;&nbsp;';
					//	chat_div.innerHTML += response.messages.message[i].text + '<br />';
					//	chat_div.scrollTop = chat_div.scrollHeight;
						//lastMessage = response.messages.message[i].id;
					//}
					//mTimer = setTimeout('getChatText();',2000); // Refresh our
																// chat in 2
																// seconds
				}
			}
			// This functions handles when the user presses enter. Instead of
			// submitting the form, we
			// send a new message to the server and return false.
			function blockSubmit() {
				lookup();
				return false;
			}
			

