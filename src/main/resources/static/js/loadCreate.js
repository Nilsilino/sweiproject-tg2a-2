$.getJSON('/createActivity',
function(data) {
	document.getElementById('code').style.display="none"
	document.getElementById('code2').style.display="none"    
});
function cancel() {
    window.history.back();
}

function sendMail() {
	$.getJSON('/MailTo?mail='+ mail.value,
			function(data) {
			});
}

function doBoth() {
	document.getElementById('verification').style.display='block'
	sendMail();
}
