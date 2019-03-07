package com.badgers.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.badgers.customer.service.OrderService;

import lombok.Setter;

// 음식 주문하기, 주문 예약하기, 반찬 선택하기, 배달하기, 주문 취소하기, 비회원 주문 정보 저장하기, 주문 내역보기, 리뷰 작성하기

public class OrderController {

	@Setter(onMethod_ = { @Autowired } )
	private OrderService service;
}
