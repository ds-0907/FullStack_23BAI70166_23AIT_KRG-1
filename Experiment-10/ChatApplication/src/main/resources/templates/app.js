let stompClient = null;

function connect() {
  const socket = new SockJS('/ws');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function () {
    console.log('Connected to WebSocket');
    stompClient.subscribe('/topic/public', function (messageOutput) {
      const msg = JSON.parse(messageOutput.body);
      showMessage(msg);
    });
  });
}

function sendMessage() {
  const sender = document.getElementById('username').value;
  const content = document.getElementById('message').value;
  if (sender && content) {
    stompClient.send('/app/sendMessage', {}, JSON.stringify({ 'sender': sender, 'content': content }));
    document.getElementById('message').value = '';
  } else {
    alert('Enter your name and message!');
  }
}

function showMessage(message) {
  const li = document.createElement('li');
  li.textContent = `${message.sender}: ${message.content}`;
  document.getElementById('messages').appendChild(li);
}

window.onload = connect;
