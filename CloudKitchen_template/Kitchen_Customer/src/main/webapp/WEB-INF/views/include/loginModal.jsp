<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Login modal -->
    <div class="modal fade" id="login_2" tabindex="-1" role="dialog" aria-labelledby="myLogin" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content modal-popup">
                <a href="#" class="close-link"><i class="icon_close_alt2"></i></a>
                <form action="#" class="popup-form" id="myLogin">
                    <div class="login_icon"><i class="icon_lock_alt"></i></div>
                    <input type="text" class="form-control form-white" placeholder="아이디">
                    <input type="text" class="form-control form-white" placeholder="비밀번호">
                    <div class="text-left">
                        <a id="findId" href="#" style="font-size: 13px;">아이디를 잊으셨나요?</a> <br/>
				    	<a class="changePw" href="#" style="font-size: 13px;">비밀번호를 잊으셨나요?</a>
                     </div>
                    <button type="button" class="btn btn-submit">로그인</button>
                </form>
            </div>
        </div>
    </div><!-- End modal -->