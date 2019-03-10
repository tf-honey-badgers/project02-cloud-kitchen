package org.badgers.controller;

import org.badgers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Setter;

@Controller
public class CustomerController {
	
	@Setter(onMethod_ = { @Autowired })
	private CustomerService service;
}
