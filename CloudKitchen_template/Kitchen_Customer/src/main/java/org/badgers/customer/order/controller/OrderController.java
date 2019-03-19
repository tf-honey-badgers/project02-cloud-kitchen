package org.badgers.customer.order.controller;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

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
	
	@PostMapping("/")
	public String registOrder(@RequestBody OrderVOExtend vo, Model model) {
		
		String url = "http://127.0.0.1:3000/controller/rest/cust/order/"+vo.getId();
		
		ResponseEntity<OrderInfoVO[]> responses  = restTemplate.postForEntity(url,vo, OrderInfoVO[].class);
		List<OrderInfoVO> list =Arrays.asList(responses.getBody());
		
		System.out.println("==============================================================================");
		System.out.println(list);
		System.out.println("==============================================================================");
		model.addAttribute("list", list);
		return "orderConfirm";
	}
}
