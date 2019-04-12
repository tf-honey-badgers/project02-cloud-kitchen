package org.badgers.rest.business.order.controller;

import org.badgers.rest.business.order.service.BizFireBaseService;
import org.badgers.rest.business.order.service.BizOrderService;
import org.badgers.rest.business.order.service.StatusChangeService;
import org.badgers.rest.firebase.JacksonUtilityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.FirebaseException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/biz/order")
@RequiredArgsConstructor
@Log4j
public class BizOrderController {

	private final BizOrderService bizOrderService;
	private final BizFireBaseService fireBaseService;
	private final StatusChangeService statusChangeService;
	//주문 상태 변경 
	@GetMapping("/{bizId}/{orderId}/{status}")
	public ResponseEntity<?> updateOrderStatus(
			@PathVariable("bizId") String bizId, 
			@PathVariable("orderId") String orderId, 
			@PathVariable("status") String status
			) throws Exception, FirebaseException, JacksonUtilityException, org.badgers.rest.firebase.FirebaseException{
		
		String changedStatus = statusChangeService.getNewStatus(status);
		
		fireBaseService.patchOrderStatus(bizId+"/"+orderId, changedStatus);
		bizOrderService.updateOrderStatus(status, bizId, orderId);
		
		if(status.equals("ORD002")||status.equals("ORD003")||status.equals("ORD005")) {
			String userToken=fireBaseService.getToken(orderId);
			return new ResponseEntity<>(userToken,HttpStatus.OK);
		}
		return new ResponseEntity<>("noMessage",HttpStatus.OK);
	}
	
	@GetMapping("/fcm/{orderId}")
	public ResponseEntity<String> getFcmToken(@PathVariable String orderId){
		log.info(orderId);
		fireBaseService.getToken(orderId);
		log.info(fireBaseService.getToken(orderId));
		
		return  new ResponseEntity<>(HttpStatus.OK);
	}
}
