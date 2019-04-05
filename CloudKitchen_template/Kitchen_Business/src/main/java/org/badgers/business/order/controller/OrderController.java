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

import lombok.extern.log4j.Log4j;

@RequestMapping("/order")
@Controller
@Log4j
public class OrderController {
	
	@Inject
	RestTemplate restTemplate;
	//사업자 주문관리 페이지로 이동
	@GetMapping("/main")
	public String test(OrderVO vo) {

		
		return "/order/order";
	}
	
	//주문 상태코드 변경  
	@PutMapping("/{bizId}/{orderId}/{status}")
	public ResponseEntity<Object> updateStatus(
			@PathVariable("bizId") String bizId, 
			@PathVariable("orderId") String orderId, 
			@PathVariable("status") String status) {
		log.info("...................주문상태코드 변경  -> "+status);
		String url = "http://localhost/rest/biz/order/"+bizId+"/"+orderId+"/"+status; 
		Object obj = restTemplate.getForEntity(url, String.class);
		return new ResponseEntity<>(obj, HttpStatus.OK);	
	}

}
