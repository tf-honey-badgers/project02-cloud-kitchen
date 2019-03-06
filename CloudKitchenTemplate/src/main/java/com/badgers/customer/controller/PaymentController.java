package com.badgers.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.badgers.customer.service.PaymentService;

import lombok.Setter;

// 결제하기

public class PaymentController {
	
	@Setter(onMethod_ = { @Autowired } )
	private PaymentService service;
}
