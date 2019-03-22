<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Register modal -->
    <div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myRegister" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content modal-popup">
                <a href="#" class="close-link"><i class="icon_close_alt2"></i></a>
                <form action="#" class="popup-form" id="myRegister">
                    <div class="login_icon"><i class="icon_lock_alt"></i></div>
                    <input type="text" class="form-control form-white" placeholder="아이디">
                    <input type="password" class="form-control form-white" placeholder="비밀번호" id="password1">
                    <input type="password" class="form-control form-white" placeholder="비밀번호 재확인" id="password2">
                    <input type="text" class="form-control form-white" placeholder="이름">
                    <input type="text" class="form-control form-white" placeholder="생년 월일">
                    <input type="text" class="form-control form-white" placeholder="휴대폰 번호">
                    <input type="email" class="form-control form-white" placeholder="Email">
                    <div>

                        <input type="radio" name="gender" value="남" style="width:23px;height:23px"><span style="font-size: 30px; color: white; padding-right: 100px;">남</span>
                        <input type="radio" name="gender" value="여" style="width:23px;height:23px"><span style="font-size: 30px; color: white">여</span>
                    </div>


                    <div id="pass-info" class="clearfix"></div>
                    <div class="checkbox-holder text-left">
                        <div class="checkbox">
                            <input type="checkbox" value="accept_2" id="check_2" name="check_2" />
                            <label for="check_2"><span>I Agree to the <strong>Terms &amp; Conditions</strong></span></label>
                        </div>
                    </div>
                    <button type="button" class="btn btn-submit">회원가입</button>
                </form>
            </div>
        </div>
    </div><!-- End Register modal -->