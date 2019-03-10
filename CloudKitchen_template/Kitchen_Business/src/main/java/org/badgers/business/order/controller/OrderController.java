package org.badgers.business.order.controller;

import org.badgers.business.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Setter;

@Controller
public class OrderController {

	@Setter(onMethod_ = { @Autowired })
	private OrderService service;
}
