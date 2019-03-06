package com.badgers.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.badgers.business.service.OrderService;

import lombok.Setter;

// 주문 받기, 주문 거부하기, 주문 취소하기, 배달 보내기, 주문 내역 보기

@RestController
public class OrderController {
	
	@Setter(onMethod_ = { @Autowired } )
	private OrderService service;
}
