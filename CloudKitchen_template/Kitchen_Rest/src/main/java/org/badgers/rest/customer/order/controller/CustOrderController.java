package org.badgers.rest.customer.order.controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.badgers.rest.common.CreateFireBasePath;
import org.badgers.rest.common.Map_TO_Object;
import org.badgers.rest.common.ToOrderAlarmVO;
import org.badgers.rest.customer.order.service.CustFireBaseService;
import org.badgers.rest.customer.order.service.CustOrderService;
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

	@PostMapping("/{key}")
	public ResponseEntity<?> registOrder(@RequestBody OrderVOExtend vo, @PathVariable("key") String key)
			throws JacksonUtilityException, Exception, FirebaseException {
		System.out.println(vo);

		
		
		// 1. mysql insert
//		orderService.excuteOrder(vo);

		// 2. mysql select
		LinkedList<OrderInfoVO> list = orderService.getOrderInfo(vo.getId());
		
		
		// 3. firebase insert
		Map<String, OrderAlarmVO> map = null;
		map = ToOrderAlarmVO.toOrderAlarmVO(list);
		firebaseService.testPutOrder(map);
		StringBuffer orderPath = null;
		StringBuffer statusPath = null;

//		while(map.) {
//			orderPath = CreateFireBasePath.getOrderPath(key, listElement);
//			//가게별 주문 정보 insert
//			firebaseService.putOrder(orderPath, map);
//			//가게별 주문 정보 상태(status) insert
//			firebaseService.putOrder(statusPath, "{\"status\":\"ORD001\"}");
//		}

//		return new ResponseEntity<>(list, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}

//for (OrderInfoVO listElement : list) {
//	orderPath = CreateFireBasePath.getOrderPath(key, listElement);
//	statusPath = CreateFireBasePath.getStatusPath(key, listElement);
//	map = Map_TO_Object.voToMap(listElement);
//	//가게별 주문 정보 insert
//	firebaseService.putOrder(orderPath, map);
//	//가게별 주문 정보 상태(status) insert
//	firebaseService.putOrder(statusPath, "{\"status\":\"ORD001\"}");
//}
