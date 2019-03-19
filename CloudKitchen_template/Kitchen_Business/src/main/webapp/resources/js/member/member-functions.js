/* 사업자 관련 각종 JavaScript 함수 모음 (로그인, 개인정보 수정 등) */
$(document).ready(function() {
	/* 사용자 정보 중 계좌정보 수정하기 */
	$('#changeAccount').on('click', function() {
		$.ajax({
    		url : 'http://localhost:12001/business/member/' + $('#bizId').val() + '/modify'
    		, type : 'POST'
			, contentType : 'application/json'
    		, data : JSON.stringify({bizId : $('#bizId').val(), account : $('#account').val()})
    		, error : function() { alert("사업자 계좌번호를 수정하는데 에러가 발생했습니다."); }
    		, success : function() { alert("성공적으로 사업자 계좌번호를 수정했습니다."); }
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
    		, error : function() { alert("가게 정보를 수정하는데 에러가 발생했습니다."); }
    		, success : function() { alert("성공적으로 가게 정보를 수정했습니다."); }
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
				'<input type="text" class="form-control form-white" placeholder="은행 계좌번호">' +
				'<button type="button" id="getId" class="btn btn-submit">ID 찾기</button>');
	});
	
	/* ID 찾기 인증 절차 */
	$('#findId').on('click', function(event) {
		event.preventDefault();
		$('.modal').modal('hide');
		$('#finder_ID').modal('show');
    	$('#getId').on('click', function() {
    		$.ajax({
        		url : 'http://localhost:12001/business/member/findId'
        		, type : 'POST'
				, contentType : 'application/json'
        		, data : JSON.stringify({
        				regNo : $('#myId input:eq(0)').val()
        				, account : $('#myId input:eq(1)').val()
        			})
        		, error : function(data) {
        			$("#myId input").remove();
	        		$("#myId h2").replaceWith("<h5>서버에 에러가 발생했습니다. 조금 있다가 다시 시도해주세요.</h5>");
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
	
	/* ID 찾은 후 로그인 페이지로 넘어가기 */
	$('body').on('click', '#goLogin', function(event){
		event.preventDefault();
		$('#login_2').modal('show');
		$('#finder_ID').modal('hide');
		$('#myId').append('<div class="login_icon" style="margin-top: 20px; margin-bottom: 10px;">' +
				'<i class="material-icons" style="width: 60px; font-size: 60px;">lock_alt</i></div>' +
				'<h2>ID 찾기</h2><h5>ID를 찾으려면 본인인증을 해주세요.</h5>' +
				'<input type="text" class="form-control form-white" placeholder="사업자 등록번호">' +
				'<input type="text" class="form-control form-white" placeholder="은행 계좌번호">' +
				'<button type="button" id="getId" class="btn btn-submit">ID 찾기</button>');
		$('#login_2 input').val("");
	});
})