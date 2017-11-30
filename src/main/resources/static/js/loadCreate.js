function cancel() {
    window.history.back();
}

function sendMail() {
	$.getJSON('/MailTo?mail='+ mail.value,
			function(data) {
			});
}

function doBoth() {
	document.getElementById('verificationpart').style.display='block';
	window.scrollTo(0,document.body.scrollHeight);
	sendMail();
}

function verify() {
	$.getJSON('/checkKey?key='+emailfield.value,
			function(data) {
					if(data.status === "true") {
						
						$.getJSON('/create?key='+ emailfield.value+"&name="+namensfeld.value+"&cat="+categoryfeld.value+"&dep="+departmentfeld.value+"&tag="+tagfeld.value+"&des="+descriptionfeld.value,
								function(data) {
									if(data.status =="true") {
										window.location.replace("/view");
									}
									else {
										document.getElementById("thanks").style.display= "block"
										window.scrollTo(0,document.body.scrollHeight);
									}
								});
					}
					else {
						document.getElementById("thanks").style.display= "block"
						window.scrollTo(0,document.body.scrollHeight);
					}
			});
	
	
}
