package com.badgers.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.badgers.common.service.LoginService;

import lombok.Setter;

// 로그인, 로그아웃, 아이디 찾기, 비밀번호 재설정하기

@RestController
public class LoginController {
	
	@Setter(onMethod_ = { @Autowired } )
	private LoginService service;
}
