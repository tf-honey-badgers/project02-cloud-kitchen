package org.badgers.rest.business.order.controller;

import org.badgers.rest.business.order.service.BizFireBaseService;
import org.badgers.rest.business.order.service.BizOrderService;
import org.badgers.rest.common.CreateFireBasePath;
import org.badgers.rest.firebase.JacksonUtilityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.FirebaseException;

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
			) throws Exception, FirebaseException, JacksonUtilityException, org.badgers.rest.firebase.FirebaseException{
		
		
		bizOrderService.updateOrderStatus(status, bizId, orderId);
		fireBaseService.patchOrderStatus(CreateFireBasePath.getStatusPath(bizId, orderId), "{\"status\":\""+status+"\"}");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
