package com.badgers.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.badgers.customer.service.CustOrderService;

import lombok.Setter;

// 음식 주문하기, 주문 예약하기, 반찬 선택하기, 배달하기, 주문 취소하기, 비회원 주문 정보 저장하기, 주문 내역보기, 리뷰 작성하기

@RestController
public class CustOrderController {

	@Setter(onMethod_ = { @Autowired } )
	private CustOrderService service;
}
