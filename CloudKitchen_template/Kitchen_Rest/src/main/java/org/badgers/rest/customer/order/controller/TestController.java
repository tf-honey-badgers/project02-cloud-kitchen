package org.badgers.rest.customer.order.controller;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.POST;

import org.badgers.rest.customer.order.firebase.FirebaseException;
import org.badgers.rest.customer.order.firebase.JacksonUtilityException;
import org.badgers.rest.customer.order.service.CustOrderService;
import org.badgers.rest.customer.order.service.FireBaseService;
import org.badgers.rest.firebasetest.Order;
import org.badgers.rest.model.OrderDetailVO;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderOptionVO;
import org.badgers.rest.model.OrderVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Inject
	private FireBaseService service;
	
	@PostMapping("/test/firebase")
	public ResponseEntity<?> test (@RequestBody Order order) throws UnsupportedEncodingException, FirebaseException, JacksonUtilityException {
		
		System.out.println("======================================================================================");
		System.out.println(order);
		Map<String, Object> testmap = new LinkedHashMap<String, Object>();
		testmap.put("8188", order);
//		testmap.put("8888", order);
//		testmap.put("8888", order);
		service.test(testmap);
		return new ResponseEntity<>( HttpStatus.OK);
		
	}

}
