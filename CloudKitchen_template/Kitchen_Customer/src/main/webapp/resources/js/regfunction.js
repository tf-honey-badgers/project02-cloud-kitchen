$(document).ready(function() {
	$('#register_btn').on('click', function() {
		
	
	var id = $('#Rid').val();
	var pass = $('#password1').val(); 
	var pass2 = $('#password2').val(); 
	var name = $('#Rname').val();
	var birth = $('#Rbirth').val();
	var phone = $('#Rphone').val();
	var email = $('#Remail').val();
	
	 if(id.length == 0){
	        alert("아이디를 입력해 주세요"); 
	        $("#Rid").focus();
	        return false;
	    }
	    
	    if(pass.length == 0){
	        alert("비밀번호를 입력해 주세요"); 
	        $("#password1").focus();
	        return false;
	    }
	 
	    if(pass != pass2){
	        alert("비밀번호가 서로 다릅니다. 비밀번호를 확인해 주세요."); 
	        $("#password2").focus();
	        return false; 
	    }
	 
	    if(name.length == 0){
	        alert("이름을 입력해주세요");
	        $("#Rname").focus();
	        return false;
	    }
	    
	    if(birth.length == 0){
	        alert("생년월일을 입력하여 주세요.");
	        $("#Rbirth").focus();
	        return false;
	    }
	    
	    if(phone.length == 0){
	        alert("핸드폰을 입력하여 주세요.");
	        $("#Rphone").focus();
	        return false;
	    }
	    
	    if(email.length == 0){
	        alert("이메일을 입력해주세요");
	        $("#Remail").focus();
	        return false;
	    }
	    
	
	    if(confirm("회원가입을 하시겠습니까?")){
	        alert("회원가입을 축하합니다");
	        return true;
	    }
	});	
});
