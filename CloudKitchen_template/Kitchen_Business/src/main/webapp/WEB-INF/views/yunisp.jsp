 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
 <!DOCTYPE html> 
 <html> 
  <head> 
  <meta charset="UTF-8"> 
  <title>Insert title here</title> 	

  </head> 
  <body> 
  <h1 id="bigOne"></h1>
  <script src="https://www.gstatic.com/firebasejs/5.9.0/firebase.js"></script>
<script>
  // Initialize Firebase
  var config = {
    apiKey: "AIzaSyDZ4Zt7FAQrf8ah4FDlGZU2-qLeinySOSs",
    authDomain: "honeybadgers-d29cf.firebaseapp.com",
    databaseURL: "https://honeybadgers-d29cf.firebaseio.com",
    projectId: "honeybadgers-d29cf",
    storageBucket: "honeybadgers-d29cf.appspot.com",
    messagingSenderId: "595672061077"
  };
  firebase.initializeApp(config);
  
  var bigOne = document.getElementById('bigOne')
  var dbRef = firebase.database().ref().child('text');
  
  dbRef.on('value', snap =>bigOne.innerText=snap.val()) ;
 
  
  
  
  function writeUserData(userId, name, email, imageUrl) {
	  firebase.database().ref('users/' + userId).set({
	    username: name,
	    email: email,
	    profile_picture : imageUrl
	  });
	}
  writeUserData('userId', 'name', 'email', 'imageUrl')
  
  
</script>
    
  </body> 
 </html>