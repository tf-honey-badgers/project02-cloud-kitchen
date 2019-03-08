package com.badgers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.badgers.service.PaymentService;

import lombok.Setter;

@Controller
public class CartController {
	
	@Setter(onMethod_ = { @Autowired })
	private PaymentService service;
}
