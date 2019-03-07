package com.badgers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.badgers.service.OrderService;

import lombok.Setter;

@Controller
public class OrderController {

	@Setter(onMethod_ = { @Autowired })
	private OrderService service;
}
