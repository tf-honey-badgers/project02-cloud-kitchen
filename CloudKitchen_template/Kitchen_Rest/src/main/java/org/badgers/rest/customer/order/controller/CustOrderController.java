package org.badgers.rest.customer.order.controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.badgers.rest.customer.order.service.CustFireBaseService;
import org.badgers.rest.customer.order.service.CustOrderService;
import org.badgers.rest.customer.order.service.ToOrderAlarmVOService;
import org.badgers.rest.firebase.FirebaseException;
import org.badgers.rest.firebase.JacksonUtilityException;
import org.badgers.rest.model.OrderAlarmVO;
import org.badgers.rest.model.OrderInfoVO;
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
@RequestMapping("/cust/order")
@RequiredArgsConstructor
public class CustOrderController {

	private final CustFireBaseService firebaseService;
	private final CustOrderService orderService;
	private final ToOrderAlarmVOService toOrderAlarmVOService;

	@PostMapping("/{key}")
	public ResponseEntity<?> registOrder(@RequestBody OrderVOExtend vo, @PathVariable("key") String key)
			throws JacksonUtilityException, Exception, FirebaseException {
		// 1. mysql insert
		orderService.excuteOrder(vo);

		// 2. mysql select
		LinkedList<OrderInfoVO> list = orderService.getOrderInfo(vo.getId());
		if(list==null) {throw new Exception();}
		// 3. firebase insert
		Map<String, Map<String,OrderAlarmVO>> map = toOrderAlarmVOService.toOrderAlarmVO(list);
		String orderPath = null;
		
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			//가게별 주문 정보 insert
			orderPath = (String)it.next();
			firebaseService.insertOrder(orderPath, map.get(orderPath));
			
			//가게별 주문 정보 상태(status) insert
		}

		return new ResponseEntity<>(list, HttpStatus.OK);

	}

}

