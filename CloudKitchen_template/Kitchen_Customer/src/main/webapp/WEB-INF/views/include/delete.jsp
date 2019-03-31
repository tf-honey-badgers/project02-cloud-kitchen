<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="modal fade" id="deletemodal" tabindex="-1" role="dialog"
			aria-labelledby="delete" aria-hidden="true">
		<div class="modal-dialog" style="margin-top: 151px;">
		<div class="modal-content modal-popup" style="position: relative;padding:1px 30px 10px 30px;
				text-align: center;background: #78cfcf;border-radius: 0px;border:none;">
			<a href="#" class="close-link"><i class="material-icons">close</i></a>
			
				<h4>클라우드 키친 탈퇴</h4>
				<div >
				<br>
				<pre style="font-size: 10px; white-space: pre-wrap;">
-클라우드 키친 회원 탈퇴시 클라우드  배달 서비스에 탈퇴되며
 
다른 제휴서비스 (사장님 사이트)는 이용이 가능합니다.

-탈퇴 후 재가입시 , 제한을 받을 수 있습니다.

-탈퇴 시 보유하고 계신 포인트는 소멸됩니다.

-탈퇴한 계정의 클라우드 키친 이용 기록은
				
모두 삭제됩니다. 삭제된 데이터는 복구가 불가능 합니다.
				
( 단, 작성된 리뷰와 결제 내역은 5년까지 보관)

[삭제되는 이용 기록]
  	"아이디,이메일,휴대폰 번호,주문 이력, 찜, 관심 지역,포인트,간단 결제 카드 정보 " 				
				</pre>
			</div>
			<form action="#" class="popup-form" id="delete" onSubmit="return isReady(this)">
			<input type="checkbox" id="status" value="MEM004" name="status" onClick="display1()">회원 탈퇴에 동의 합니다.
			<button type="button" id="deleteCustomer" class="btn btn-submit" style="display:none; background-color: red;">클라우드키친 탈퇴</button>
			<button type="submit" id="deleteyet" class="btn btn-submit">체크 박스를 클릭하세요.</button>
			</form>
		</div>
	</div>
</div>

<script lang=javascript>
function display1(box){
	deleteyet.style.display = 'none';
	deleteCustomer.style.display = 'block';
	}


function isFilled( elm ) { 
        if ( elm.value == "" || elm.value == null ) 
        return false; 
        else 
        return true;
}

function isReady( form ) {
    if ( ! $('input[name="status"]:checked').val() ) {
        alert('체크박스에 체크해주세요.');
        $('input[name="status"]').focus();
        return false;
    }
}

</script>