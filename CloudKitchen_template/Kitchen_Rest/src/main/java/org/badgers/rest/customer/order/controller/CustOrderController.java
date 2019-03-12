package org.badgers.rest.customer.order.controller;

import org.badgers.rest.customer.order.service.CustOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Setter;

@Controller
public class CustOrderController {
	
	@Setter(onMethod_ = { @Autowired })
	private CustOrderService service;
	
	
	@RequestMapping(value = "/myhome", method = RequestMethod.GET)
	public String test() throws Exception{
			service.excuteOrder();
		
		return "home";
	}
	
	
}
