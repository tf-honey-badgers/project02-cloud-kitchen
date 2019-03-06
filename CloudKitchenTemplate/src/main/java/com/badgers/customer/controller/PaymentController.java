package com.badgers.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.badgers.customer.service.PaymentService;

import lombok.Setter;

// 결제하기

@RestController
public class PaymentController {
	
	@Setter(onMethod_ = { @Autowired } )
	private PaymentService service;
}
