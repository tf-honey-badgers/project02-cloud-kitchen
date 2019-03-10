package org.badgers.customer.cart.controller;

import org.badgers.customer.order.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Setter;

@Controller
public class CartController {
	
	@Setter(onMethod_ = { @Autowired })
	private PaymentService service;
}
