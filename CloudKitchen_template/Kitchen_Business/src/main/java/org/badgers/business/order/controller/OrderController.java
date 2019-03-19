package org.badgers.business.order.controller;

import javax.inject.Inject;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.badgers.business.model.OrderVO;
import org.badgers.business.model.OrderVOExtend;
import org.badgers.business.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;

@RequestMapping("/order")
@Controller
public class OrderController {

	@Setter(onMethod_ = { @Autowired })
	private OrderService service;
	
	@Inject
	RestTemplate restTemplate;
	
	@GetMapping("/main")
	public String test(OrderVO vo) {

		
		return "yuni";
	}
	
	@PutMapping("/{bizId}/{orderId}/{status}")
	public String test2(
			@PathVariable("bizId") String bizId, 
			@PathVariable("orderId") String orderId, 
			@PathVariable("status") String status) {
		
		String url = "http://127.0.0.1:3000/rest/biz/order/"+bizId+"/"+orderId+"/"+status; 
		Object obj = restTemplate.getForEntity(url, String.class);
		System.out.println("=============================================================");
		System.out.println(obj);

		return "yuni";
	}

}
