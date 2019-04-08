/* 사업자 관련 각종 JavaScript 함수 모음 (로그인, 개인정보 수정 등) */
$(document).ready(function() {	
	
	// S3 업로드를 위한 초기화작업
	var albumBucketName = 'honeybadgersfile';
	var bucketRegion = 'ap-northeast-2';
	var IdentityPoolId = 'ap-northeast-2:1817daac-6a56-4e36-9a56-9bc772d96a0b';
	
	AWS.config.update({
	  region: bucketRegion,
	  credentials: new AWS.CognitoIdentityCredentials({
	    IdentityPoolId: IdentityPoolId
	  })
	});
	
	var s3 = new AWS.S3({
	  apiVersion: '2006-03-01',
	  params: {Bucket: 'honeybadgersfile'}
	}); // S3 초기화 끝
	
	function updatePhoto(bizId) {
		  var files = document.getElementById('bizPhoto').files;
		  if (!files.length) {
		    return alert('Please choose a file to upload first.');
		  }
		  var file = files[0];
		  var fileName = bizId+'.png';
		  var albumName = 'MenuPhoto';
		  var albumPhotosKey = encodeURIComponent(albumName) + '/';
		  var photoKey = albumPhotosKey + fileName;
		  console.log(photoKey);
		  s3.upload({
		    Key: photoKey,
		    Body: file,
		    ACL: 'public-read'
		  }, function(err, data) {
		    if (err) {
		      return alert('There was an error uploading your photo: ', err.message);
		    }
//		    alert('사진 업로드 완료');
		  });
		}
  
	function deletePhoto(bizId) {
		let albumPath = 'MenuPhoto/';
		let extention = '.png';
		let photoName = albumPath+bizId+extention;
		  s3.deleteObject({Key: photoName}, function(err, data) {
		    if (err) {
		      return alert('There was an error deleting your photo: ', err.message);
		    }
		    alert('Successfully deleted photo.');
		  });
		}
	
	
	/* 사용자 정보 중 계좌정보 수정하기 */
	$('#changeAccount').on('click', function() {
		$.ajax({
    		url : '/business/member/' + $('#bizId').val() + '/modify'
    		, type : 'POST'
			, contentType : 'application/json'
    		, data : JSON.stringify({bizId : $('#bizId').val(), account : $('#account').val()})
    		, error : function() { md.showNotification('bottom', 'right', 'danger', '사업자 계좌번호를 수정하는데 에러가 발생했습니다.'); }
    		, success : function() { md.showNotification('bottom','right', 'info', '성공적으로 사업자 계좌번호를 수정했습니다.'); }
		});
	});

	/* 가게 정보 중 최소주문금액, 생방송 키 코드, 가게 소개글 수정하기 */
	$('#changeBiz').on('click', function() {
		$.ajax({
    		url : '/business/member/' + $('#bizId').val() + '/modify'
    		, type : 'POST'
			, contentType : 'application/json'
    		, data : JSON.stringify({
    				bizId : $('#bizId').val()
    				, minAmt : $('#minAmt').val()
    				, bizLiveStrm : $('#bizLiveStrm').val()
    				, info : $('#bizInfo').val()
    			})
    		, error : function() { md.showNotification('bottom', 'right', 'danger', '가게 정보를 수정하는데 에러가 발생했습니다.'); }
    		, success : function() { 
    			md.showNotification('bottom','right', 'info', '성공적으로 가게 정보를 수정했습니다.');
    			deletePhoto($('#bizId').val());
    			
    			setTimeout(function(){
    				updatePhoto($('#bizId').val());
    			},1000);
    		}
		});
	});
	
	/* YouTube 생방송 시작하면 iframe player src 속성용 코드 입력하기 (biz테이블 bizLiveStrm컬럼 사용) */
	$('#changeBizLiveStrm').on('click', function() {
		$.ajax({
    		url : '/business/member/livestrm/' + $('#bizId').val() + '/' + $('#bizLiveStrm').val()
    		, type : 'GET'
			, contentType : 'application/json'
    		, error : function() { md.showNotification('bottom', 'right', 'danger', 'YouTube LiveStreaming 코드를 입력하는데 에러가 발생했습니다.'); }
			, success : function(data) { md.showNotification('bottom','right', 'info', '성공적으로 가게 정보를 수정했습니다.'); }
		});
	});

	/* modal의 "X" 버튼을 눌러 닫을 때 modal을 숨기고 초기화하기 */
	$('body').on('click', '.modal-popup .close-link', function(event){
		event.preventDefault();
		$('.modal').modal('hide');
		$('#myLogin input').val("");
		$('#myId').text("");
		$('#myId').append('<div class="login_icon" style="margin-top: 20px; margin-bottom: 10px;">' +
				'<i class="material-icons" style="width: 60px; font-size: 60px;">lock_alt</i></div>' +
				'<h2>ID 찾기</h2><h5>ID를 찾으려면 본인인증을 해주세요.</h5>' +
				'<input type="text" class="form-control form-white" placeholder="사업자 등록번호">' +
				'<input type="password" class="form-control form-white" placeholder="은행 계좌번호">' +
				'<button type="button" id="getId" class="btn btn-submit">ID 찾기</button>');
	});
	
	/* 로그인 절차 */
	$('#myLogin button').on('click', function() {		
		var cnt=0;
		var inputCheck= $(this).siblings('span.bmd-form-group').find('input');
		inputCheck.each(function(i,v){
			if(v.value===null||v.value===undefined||v.value===''){
				cnt++;
				return;
			}
		})
		
		if(cnt===0){
			$.ajax({
	    		url : '/business/member/login'
	    		, type : 'POST'
				, contentType : 'application/json'
				, dataType : 'text'
	    		, data : JSON.stringify({
	    				bizId : $('#myLogin input:eq(0)').val()
	    				, pw : $('#myLogin input:eq(1)').val()
	    			})
	    		, error : function(data) {
	    			console.log(data);
	    		}
	    		, success : function(data) {
	    			if(data == "success") {
	    				window.location.href = "/business/main?msg=success";
	    			} else {
	    				if(data==='server disconnected') {
	    					md.showNotification('top', 'center', 'danger', 'server disconnected');  
	    					$('.modal').modal('hide');	
	    				} else if(data==='fail'){
	    					md.showNotification('top', 'center', 'danger', '아이디 혹은 비밀번호를 다시 확인해 주시기 바랍니다 ');  
	    				}
	       			}
	    			$('#myLogin input').val("");
	    		}
			});
		}else{
			alert('빠트린 입력란이 있는지 확인해 주세요');
		}
	});
	
	/* ID 찾기 인증 절차 */
	$('#findId').on('click', function(event) {
		event.preventDefault();
		$('.modal').modal('hide');
		$('#finder').modal('show');
    	$('#getId').on('click', function() {
    		$.ajax({
        		url : '/business/member/verify'
        		, type : 'POST'
				, contentType : 'application/json'
        		, data : JSON.stringify({
        				regNo : $('#myId input:eq(0)').val()
        				, account : $('#myId input:eq(1)').val()
        			})
        		, error : function(data) {
        			$("#myId input").remove();
	        		$("#myId h2").replaceWith("<h5>에러가 발생했습니다. 조금 있다가 다시 시도해주세요.</h5>");
	        		$('#myId h5:eq(1)').remove();
	        		$('#myId #getId').remove();
        		}
        		, success : function(data) {
        			if(data != "") {
		        		$("#myId input").remove();
		        		$("#myId h2").replaceWith("<h5>성공적으로 사업자 ID를 찾았습니다.</h5>");
		        		$('#myId h5:eq(1)').text("사업자 ID는 " + data + "입니다.");
		        		$('#myId #getId').replaceWith('<button type="button" id="goLogin" class="btn btn-submit">로그인하러 가기</button>');		        				
        			} else {
	        			$("#myId input").remove();
		        		$("#myId h2").replaceWith("<h5>사업자 ID를 찾는데 실패했습니다.</h5>");
		        		$('#myId h5:eq(1)').text("사업자 등록번호, 계좌번호를 다시 확인하시고 다시 입력해주세요.");
		        		$('#myId #getId').remove();
        			}
        		}
    		});
    	})
	});
	
	/* PW 재설정 절차 */
	$('.changePw').on('click', function(event) {
		event.preventDefault();
		$('.modal').modal('hide');
		$('#finder h2').text("PW 재설정");
		$('#finder h5').text("PW을 재설정하려면 본인인증을 해주세요.").after('<input type="text" class="form-control form-white" placeholder="사업자 아이디">');
		$('#finder button').text('본인인증하기')
		$('#finder').modal('show');
    	$('#getId').on('click', function() {
    		$.ajax({
        		url : '/business/member/verify'
        		, type : 'POST'
				, contentType : 'application/json'
        		, data : JSON.stringify({
        				bizId : $('#myId input:eq(0)').val()
        				, regNo : $('#myId input:eq(1)').val()
        				, account : $('#myId input:eq(2)').val()
        			})
        		, error : function(data) {
        			$("#myId input").remove();
	        		$("#myId h2").replaceWith("<h5>에러가 발생했습니다. 조금 있다가 다시 시도해주세요.</h5>");
	        		$('#myId h5:eq(1)').remove();
	        		$('#myId #getId').remove();
        		}
        		, success : function(data) {
        			if(data != "") {
		        		$('#myId h5').text("본인증에 성공했습니다. PW를 재설정해주세요.");
		        		$('#myId input').not(':eq(0)').val("").attr( {'placeholder' : '비밀번호를 입력해주세요', 'type' : 'password'} ).css( {'margin-top': '0px'} );
 		        		$('#myId input:eq(0)').attr( {'type' : 'hidden'} );
		        		$('#myId input:eq(1)').before('<label style="color: white;">새 비밀번호 입력하기</label>');
		        		$('#myId input:eq(1)').after('<label style="color: white;">새 비밀번호 다시 입력하기</label>');
		        		$('#myId #getId').replaceWith('<button type="button" id="changePw" class="btn btn-submit">비밀번호 재설정</button>');
        			} else {
	        			$("#myId input").remove();
		        		$("#myId h2").replaceWith("<h5>본인인증하는데 실패했습니다.</h5>");
		        		$('#myId h5:eq(1)').text("사업자 아이디, 사업자 등록번호, 계좌번호를 다시 확인하시고 다시 입력해주세요.");
		        		$('#myId #getId').remove();
        			}
        		}
    		});
    	})
	});
	
	/* ID 찾은 후 로그인 페이지로 넘어가기 */
	$('body').on('click', '#goLogin', function(event){
		event.preventDefault();
		$('#login_2').modal('show');
		$('#finder').modal('hide');
		$('#myId').children().remove();
		$('#myId').append('<div class="login_icon" style="margin-top: 20px; margin-bottom: 10px;">' +
				'<i class="material-icons" style="width: 60px; font-size: 60px;">lock_alt</i></div>' +
				'<h2>ID 찾기</h2><h5>ID를 찾으려면 본인인증을 해주세요.</h5>' +
				'<input type="text" class="form-control form-white" placeholder="사업자 등록번호">' +
				'<input type="text" class="form-control form-white" placeholder="은행 계좌번호">' +
				'<button type="button" id="getId" class="btn btn-submit">ID 찾기</button>');
		$('#login_2 input').val("");
	});
	
	/* 비밀번호 재설정 modal에서 재설정하기 클릭 시 실행 */
	$('body').on('click', '#changePw', function(event) {
		event.preventDefault();
		const hiddenId = $('#myId input:eq(0)').val();
		const pwOrg = $('#myId input:eq(1)').val();
		const pwChk = $('#myId input:eq(2)').val();
		/* 입력한 2개 비밀번호가 일치하지 않을 경우 함수를 종료한다 */
		if(pwOrg != pwChk) {
			$('#myId label').not(':eq(0), :eq(1)').remove();
    		$('#myId input:eq(2)').after('<label style="color: red; font-size: 16px;">비밀번호가 일치하지 않습니다.</label>');
			return;
		}

		$.ajax({
    		url : '/business/member/' + hiddenId + '/modify'
    		, type : 'POST'
			, contentType : 'application/json'
    		, data : JSON.stringify({
    				bizId : hiddenId
    				, pw : pwOrg
    			})
    		, error : function() {
    			$("#myId h2").replaceWith("<h5>에러가 발생했습니다. <br> 조금 있다가 다시 시도해주세요.</h5>");
    			$("#myId input").remove();
    			$('#myId label').remove();
        		$('#myId h5:eq(1)').remove();
        		$('#myId #getId').remove();
    		}
    		, success : function() {
    			md.showNotification('bottom', 'right', 'info', '성공적으로 비밀번호를 수정했습니다.');
    			$('.modal').modal('hide');
    			$('#myLogin input').val("");
    			$('#myId').text("");
    			$('#myId').children().remove();
    			$('#myId').append('<div class="login_icon" style="margin-top: 20px; margin-bottom: 10px;">' +
    					'<i class="material-icons" style="width: 60px; font-size: 60px;">lock_alt</i></div>' +
    					'<h2>ID 찾기</h2><h5>ID를 찾으려면 본인인증을 해주세요.</h5>' +
    					'<input type="text" class="form-control form-white" placeholder="사업자 등록번호">' +
    					'<input type="text" class="form-control form-white" placeholder="은행 계좌번호">' +
    					'<button type="button" id="getId" class="btn btn-submit">ID 찾기</button>');
    		}
		});
	});
});