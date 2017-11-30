function Cancel() {
    window.history.back();
};

function sendMail() {
	$.getJSON('/MailTo?mail='+ mail.value,
			function(data) {
			});
		document.getElementById('code').style.display='none';
}
