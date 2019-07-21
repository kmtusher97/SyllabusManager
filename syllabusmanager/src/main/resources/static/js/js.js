

function makeReq() {
    alert("change");
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://localhost:8081/cs/testReq", true ); // false for synchronous request
    xmlHttp.send();
}