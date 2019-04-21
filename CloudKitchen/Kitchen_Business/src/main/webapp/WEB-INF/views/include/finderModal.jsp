<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="modal fade" id="finder" tabindex="-1" role="dialog"
	aria-labelledby="myLogin" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 151px;">
		<div class="modal-content modal-popup" style="position: relative;padding:1px 30px 10px 30px;
					text-align: center;background: #78cfcf;border-radius: 0px;border:none;">
			<a href="#" class="close-link"><i class="material-icons">close</i></a>
			<form action="#" class="popup-form" id="myId">
				<div class="login_icon" style="margin-top: 20px; margin-bottom: 10px;"><i class="material-icons" style="width: 60px; font-size: 60px;">lock_alt</i></div>
				<h2>ID 찾기</h2>
				<h5>ID를 찾으려면 본인인증을 해주세요.</h5>
				<input type="text" class="form-control form-white" placeholder="사업자 등록번호">
				<input type="text" class="form-control form-white" placeholder="은행 계좌번호">
				<button type="button" id="getId" class="btn btn-submit">ID 찾기</button>
			</form>
		</div>
	</div>
</div>