package org.badgers.business.order.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.badgers.business.util.Push;
import org.badgers.business.model.OrderVO;
import org.badgers.business.util.RestDomain;
import org.badgers.business.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RequestMapping("/order")
@Controller
@Log4j
public class OrderController {
	
	@Inject
	RestTemplate restTemplate;
	
	@Autowired
	Push push;
	
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
			@PathVariable("status") String status) throws IOException {
		
		String url =  RestDomain.restDomain+"/biz/order/"+bizId+"/"+orderId+"/"+status; 
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		String userToken=response.getBody();

		if(!(userToken.equals("noMessage"))) {
			push.send(userToken, Status.valueOf(status).getmessage());
		}
		
		System.out.println("obj가 뭐냐?------------------------------");
		System.out.println(response.getBody());
		
		return new ResponseEntity<>(userToken, HttpStatus.OK);	
	}

}
