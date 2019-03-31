package org.badgers.customer.order.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.badgers.customer.model.OrderInfoForViewVO;
import org.badgers.customer.model.OrderInfoVO;
import org.badgers.customer.model.OrderVOExtend;
import org.badgers.customer.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Setter(onMethod_ = { @Autowired })
	private OrderService oService;
	
	@Inject
	RestTemplate restTemplate;
//	
//	@Setter(onMethod_ = { @Autowired })
//	private PaymentService pService;
	
	@PostMapping("/payment/{staus}")
	public String registOrder(@RequestBody OrderVOExtend vo, Model model) {
		
		String url = "http://127.0.0.1:80/rest/cust/order/"+vo.getId();
		System.out.println(url);
		
		ResponseEntity<String> responses  = restTemplate.postForEntity(url,vo, String.class);
//		List<OrderInfoVO> list =Arrays.asList(responses.getBody());
		
		String list = responses.getBody();
		
		System.out.println(list);
		model.addAttribute("list", list);
		
		return "order/order_3_confirm";
	}
}
