$.getJSON('/createActivity',
function(data) {
	document.getElementById('code').style.visibility="hidden"
	document.getElementById('code2').style.visibility="hidden"    
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
