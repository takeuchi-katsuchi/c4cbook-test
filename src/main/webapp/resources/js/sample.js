function sendMessage2() {
	var message = document.getElementById('t2').value;

	document.sendMessage2Form.message.value = message;
	document.sendMessage2Form.submit();
}