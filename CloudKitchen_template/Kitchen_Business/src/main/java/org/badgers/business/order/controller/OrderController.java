package org.badgers.business.order.controller;

import javax.inject.Inject;

import org.badgers.business.model.OrderVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/order")
@Controller
public class OrderController {
	
	@Inject
	RestTemplate restTemplate;
	
	@GetMapping("/main")
	public String test(OrderVO vo) {

		
		return "/order/order";
	}
	
	@PutMapping("/{bizId}/{orderId}/{status}")
	public ResponseEntity<Object> updateStatus(
			@PathVariable("bizId") String bizId, 
			@PathVariable("orderId") String orderId, 
			@PathVariable("status") String status) {
		
		String url = "http://localhost/rest/biz/order/"+bizId+"/"+orderId+"/"+status; 
		Object obj = restTemplate.getForEntity(url, String.class);
		System.out.println("=============================================================");
		System.out.println(obj);
		return new ResponseEntity<>(obj, HttpStatus.OK);	
	}

}
