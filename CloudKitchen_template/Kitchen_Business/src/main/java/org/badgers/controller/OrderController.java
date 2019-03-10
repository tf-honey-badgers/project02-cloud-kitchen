package org.badgers.controller;

import org.badgers.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Setter;

@Controller
public class OrderController {

	@Setter(onMethod_ = { @Autowired })
	private OrderService service;
}
