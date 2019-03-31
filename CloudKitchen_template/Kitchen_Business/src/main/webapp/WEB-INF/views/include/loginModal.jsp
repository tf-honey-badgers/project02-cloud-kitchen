<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="modal fade" id="login_2" tabindex="-1" role="dialog" aria-labelledby="myLogin" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 151px;">
		<div class="modal-content modal-popup" style="position: relative;padding:1px 30px 10px 30px; text-align: center;background: #78cfcf;border-radius: 0px;border:none;">
			<a href="javascrpit:void()" class="close-link"><i class="material-icons">close</i></a>
			<form action="http://localhost:3000/business/member/login" class="popup-form" id="myLogin">
				<div class="login_icon" style="margin-top: 20px; margin-bottom: 10px;"><i class="material-icons" style="width: 60px; font-size: 60px;">lock_alt</i></div>
				<input type="text" class="form-control form-white id" placeholder="아이디">
				<input type="password" class="form-control form-white pwd" placeholder="비밀번호">
				<div class="text-left">
					<a id="findId" href="#" style="font-size: 13px;">아이디를 잊으셨나요?</a> <br/>
					<a class="changePw" href="#" style="font-size: 13px;">비밀번호를 잊으셨나요?</a>
				</div>
				<button type="button" class="btn btn-submit" >로그인</button>
			</form>
		</div>
	</div>
</div>