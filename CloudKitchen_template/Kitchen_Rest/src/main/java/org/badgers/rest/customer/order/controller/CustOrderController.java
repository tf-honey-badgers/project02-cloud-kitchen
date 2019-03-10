package org.badgers.rest.customer.order.controller;

import org.badgers.rest.customer.order.service.CustOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Setter;

@Controller
public class CustOrderController {
	
	@Setter(onMethod_ = { @Autowired })
	private CustOrderService service;
}
