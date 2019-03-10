package org.badgers.rest.customer.order.controller;

import org.badgers.rest.customer.order.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Setter;

@Controller
public class PaymentController {
	
	@Setter(onMethod_ = { @Autowired })
	private PaymentService service;
}
