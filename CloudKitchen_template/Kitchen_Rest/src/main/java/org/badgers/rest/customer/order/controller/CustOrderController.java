package org.badgers.rest.customer.order.controller;

import java.util.List;

import org.badgers.rest.customer.order.service.CustOrderService;
import org.badgers.rest.model.OrderInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;

@RestController
public class CustOrderController {
	
	@Setter(onMethod_ = { @Autowired })
	private CustOrderService service;
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String test() throws Exception {
		service.excuteOrder();
		return "home";
	}
	
	@GetMapping("/order/{orderId}")
	public List<OrderInfoVO> getOrderInfo(
			@PathVariable("orderId") String orderId
			) throws Exception{
		System.out.println(orderId);
		service.getOrderInfo();
				return null;
		
	}
	
	
	
	
}
