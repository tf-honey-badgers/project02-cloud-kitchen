package org.badgers.customer.order.controller;

import org.badgers.customer.order.service.OrderService;
import org.badgers.customer.order.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Setter;

@Controller
public class OrderController {
	
	@Setter(onMethod_ = { @Autowired })
	private OrderService oService;
	
	@Setter(onMethod_ = { @Autowired })
	private PaymentService pService;
}
