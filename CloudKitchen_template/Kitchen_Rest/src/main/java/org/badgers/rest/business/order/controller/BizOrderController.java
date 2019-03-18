package org.badgers.rest.business.order.controller;

import java.util.HashMap;
import java.util.Map;

import org.badgers.rest.business.order.service.BizOrderService;
import org.badgers.rest.business.order.service.BizFireBaseService;
import org.badgers.rest.firebase.FirebaseException;
import org.badgers.rest.firebase.JacksonUtilityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("rest/biz/order")
@RequiredArgsConstructor
public class BizOrderController {

	private final BizOrderService bizOrderService;
	private final BizFireBaseService fireBaseService;
	
	@PutMapping("/{bizId}/{orderId}/{status}")
	public ResponseEntity<?> updateOrderStatus(
			@PathVariable("bizId") String bizId, 
			@PathVariable("orderId") String orderId, 
			@PathVariable("status") String status
			) throws Exception, FirebaseException, JacksonUtilityException{
		
//		System.out.println(status+","+orderId+","+bizId);
		
//		bizOrderService.updateOrderStatus(status, bizId, orderId);
		String key = orderId;
		Map<String, Object> data = new HashMap<>();
		data.put("orderDetails/0/menuprice", status);
		fireBaseService.patchOrderStatus(key, data);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
