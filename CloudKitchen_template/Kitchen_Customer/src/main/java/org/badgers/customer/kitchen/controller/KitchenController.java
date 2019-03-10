package org.badgers.customer.kitchen.controller;

import org.badgers.customer.kitchen.service.KitchenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Setter;

@Controller
public class KitchenController {
	
	@Setter(onMethod_ = { @Autowired })
	private KitchenService service;
}
