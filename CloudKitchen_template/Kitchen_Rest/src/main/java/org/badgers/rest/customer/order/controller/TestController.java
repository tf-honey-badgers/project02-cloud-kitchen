package org.badgers.rest.customer.order.controller;

import java.util.List;
import java.util.Map;

import org.badgers.rest.customer.order.firebase.FirebaseException;
import org.badgers.rest.customer.order.firebase.JacksonUtilityException;
import org.badgers.rest.customer.order.firebase.Map_TO_Object;
import org.badgers.rest.customer.order.service.CustOrderService;
import org.badgers.rest.customer.order.service.FireBaseService;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderVOExtend;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestController {

	private final FireBaseService service;
	private final CustOrderService orderService;
	private final Map_TO_Object mto; 
//	private final DatabaseReference databaseReference;
	// 이거 주석 풀면 qualify Exception

	@PostMapping("/test/tj/fire/{key}")
	public ResponseEntity<?> tjTest(@RequestBody OrderVOExtend vo, @PathVariable("key") String key)
			throws JacksonUtilityException, Exception, FirebaseException {

		//1. firebase insert
		Map<String, Object> map = mto.voToMap(vo);
		service.putFirebase(key, map);

		//2. mysql insert
		orderService.excuteOrder(vo);
		
		//3. mysql select
		List<OrderInfoVO> list = orderService.getOrderInfo(vo.getId());
		
		return new ResponseEntity<>(list, HttpStatus.OK);

	}
}
