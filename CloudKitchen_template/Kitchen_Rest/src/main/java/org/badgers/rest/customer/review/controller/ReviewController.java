package org.badgers.rest.customer.review.controller;

import org.badgers.rest.customer.kitchen.service.KitchenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Setter;

@Controller
public class ReviewController {
	
	@Setter(onMethod_ = { @Autowired })
	private KitchenService service;
}
