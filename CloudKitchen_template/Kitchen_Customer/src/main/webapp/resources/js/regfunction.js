$(document).ready(function() {

	var id =$('#Rid');
	var idInfo =$('#id-info')
	var email = $('#Remail');
	var emailInfo = $('#email-info');
	
	check(id,idInfo,email,emailInfo);
});	
	
function check(id,idInfo,email,emailInfo){
	var emailChk = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	var idChk =/^[a-z]+[a-z0-9]{5,19}$/g;

	$(id).on('keyup',function(e){
	  if( idChk.test( id.val())) {
          idInfo.removeClass().addClass('strong').html("id clear!");
    
      }
	  else if(idChk.test(id.val())==false){
		idInfo.removeClass().addClass('weakpass').html("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다."); 
	  }

	});
	$(email).on('keyup',function(e){
		
		if(emailChk.test(email.val()))
			{
			
			emailInfo.removeClass().addClass('strong').html("email clear!")
			}
		else if(emailChk.test(email.val())==false){

		        
			emailInfo.removeClass().addClass('weakpass').html("이 메일형식이 올바르지 않습니다. ")	;
		   

		}
	});
	
}	
	

