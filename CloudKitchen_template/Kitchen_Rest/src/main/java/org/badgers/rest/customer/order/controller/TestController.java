package org.badgers.rest.customer.order.controller;

import javax.ws.rs.POST;

import org.badgers.rest.customer.order.service.CustOrderService;
import org.badgers.rest.model.OrderDetailVO;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderOptionVO;
import org.badgers.rest.model.OrderVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	private CustOrderService service;
	
	@PostMapping("/test/yuni")
	public ResponseEntity<?> test (OrderVO vo1 , OrderDetailVO vo2 , OrderOptionVO vo3) {
		
		System.out.println("======================================================================================");
		System.out.println(vo1);
		System.out.println(vo2);
		System.out.println(vo3);
		return new ResponseEntity<>(service.getOrder("order_1"), HttpStatus.OK);
		
	}

}
