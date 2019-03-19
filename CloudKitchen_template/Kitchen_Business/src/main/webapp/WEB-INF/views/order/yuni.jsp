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
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
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
  var dbRef = firebase.database().ref().child('text').child('치즈크러스트');
  
  var obj = dbRef.on('value', function(snapshot){
	  bigOne.innerText=snapshot.val()
	  
	  var obj2 = Object.keys(snapshot.val())
  console.log(obj2)
  });
		  /* snap =>bigOne.innerText=snap.val()) ; */
		  
	/* 트랜젝션 */	  
/* 	function toggleStar(postRef, uid) {
  postRef.transaction(function(post) {
    if (post) {
      if (post.stars && post.stars[uid]) {
        post.starCount--;
        post.stars[uid] = null;
      } else {
        post.starCount++;
        if (!post.stars) {
          post.stars = {};
        }
        post.stars[uid] = true;
      }
    }
    return post;
  });
   */
  /* 하위항목 변경 */
/*    var dbRef = firebase.database().ref('text')
  dbRef.on('child_changed', function(data) {
	 
	  console.log(data)
	  console.log(data.val())
	  data.val().text
	}); */
   var dbRef = firebase.database().ref('text')
  dbRef.on('value', function(data) {
	 
	 /*  console.log(data) */
	  console.log(data.val())
	  data.val().text
	});

		  
		  
		  
		  
		  
 
  
  
  function writeUserData(userId, name, email, imageUrl) {
	  firebase.database().ref('users/' + userId).set({
	    username: name,
	    email: email,
	    profile_picture : imageUrl
	  });
	}
 /*  writeUserData('userId', 'name', 'email', 'imageUrl') */
  
  
</script>
    
  </body> 
 </html>