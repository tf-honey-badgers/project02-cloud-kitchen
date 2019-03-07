package com.badgers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.badgers.service.CustomerService;

import lombok.Setter;

@Controller
public class CustomerController {
	
	@Setter(onMethod_ = { @Autowired })
	private CustomerService service;
}
