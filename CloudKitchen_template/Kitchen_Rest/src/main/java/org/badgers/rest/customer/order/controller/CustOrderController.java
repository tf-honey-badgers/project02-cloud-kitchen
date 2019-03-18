package org.badgers.rest.customer.order.controller;

import java.util.Map;

import org.badgers.rest.common.Map_TO_Object;
import org.badgers.rest.customer.order.firebase.FirebaseException;
import org.badgers.rest.customer.order.firebase.JacksonUtilityException;
import org.badgers.rest.customer.order.service.CustOrderService;
import org.badgers.rest.customer.order.service.FireBaseService;
import org.badgers.rest.model.OrderVOExtend;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/order")
@RequiredArgsConstructor
public class CustOrderController {

	private final FireBaseService service;
	private final CustOrderService orderService;

	@PostMapping("/{key}")
	public ResponseEntity<?> tjTest(@RequestBody OrderVOExtend vo, @PathVariable("key") String key)
			throws JacksonUtilityException, Exception, FirebaseException {

		//1. firebase insert
		Map<String, Object> map = Map_TO_Object.voToMap(vo);
		service.putFirebase(key, map);

		//2. mysql insert
//		orderService.excuteOrder(vo);
		
		//3. mysql select
//		List<OrderInfoVO> list = orderService.getOrderInfo(vo.getId());
		
//		return new ResponseEntity<>(list, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.OK);

	}
}

