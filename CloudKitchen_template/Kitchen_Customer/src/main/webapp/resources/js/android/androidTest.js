/**
 * 
 */

function setMessage(arg) { 
   document.getElementById('textMessageFromApp').innerHTML = arg;
}

function sendMessage(msg){
   window.HybridApp.setMessage(msg);
}