$.getJSON('/details?id='+getParameterByName('id'),
function(data) {
	$('#namensfeld').append("<textarea rows=\"1\" cols=\"50\">"+data.name+"</textarea>");
	$('#departmentfeld').append("<textarea rows=\"1\" cols=\"50\">"+data.department+"</textarea>");
	
	var s = "<textarea rows=\"2\" cols=\"50\">";
	
	for(var i=0;i<data.tags.length;i++) {
		if(i == (data.tags.length-1)) {
			s += data.tags[i];
		}
		else {
			s += data.tags[i] + ", ";
		}
	}
	
	$('#tagfeld').append(s+"</textarea>");
	$('#descriptionfeld').append("<textarea rows=\"4\" cols=\"50\">"+data.description+"</textarea>");
	
	document.getElementById('verification').style.display='none'
	document.getElementById('thanks').style.display='none'
});
    
function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

function goBack() {
    window.history.back();
}

function sendMail() {
	$.getJSON('/MailTo?mail='+ mail.value,
			function(data) {
			});
	
	document.getElementById('thanks').style.display='block'
}
    
