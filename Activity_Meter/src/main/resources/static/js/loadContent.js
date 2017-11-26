function userAction() {    
    var xhttp = new JSONHttpRequest();
    xhttp.open("GET", "/list", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
    var response = JSON.parse(xhttp.responseText);
}