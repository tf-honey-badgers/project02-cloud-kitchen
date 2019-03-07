package com.badgers.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.badgers.customer.service.CustomerService;

import lombok.Setter;

// 소비자 회원가입, 인증, 개인정보수정, 탈퇴, 아이디 찾기, 가게 찜하기

@RestController
public class CustomerController {

	@Setter(onMethod_ = { @Autowired } )
	private CustomerService service;
}
