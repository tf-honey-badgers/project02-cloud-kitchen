package org.badgers.rest.customer.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.badgers.rest.common.Map_TO_Object;
import org.badgers.rest.customer.order.service.CustFireBaseService;
import org.badgers.rest.customer.order.service.CustOrderService;
import org.badgers.rest.firebase.FirebaseException;
import org.badgers.rest.firebase.JacksonUtilityException;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderVOExtend;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/cust/order")
@RequiredArgsConstructor
public class CustOrderController {

	private final CustFireBaseService firebaseService;
	private final CustOrderService orderService;

	@PostMapping("/{key}")
	public ResponseEntity<?> registOrder(@RequestBody OrderVOExtend vo, @PathVariable("key") String key)
			throws JacksonUtilityException, Exception, FirebaseException {

		//1. firebase insert
//		Map<String, Object> map = Map_TO_Object.voToMap(vo);
//		firebaseService.putOrder(key, map);
		
		
		//2. mysql insert
//		orderService.excuteOrder(vo);
		
		//3. mysql select
		List<OrderInfoVO> list = orderService.getOrderInfo(vo.getId());
		System.out.println(list);
		
		
		return new ResponseEntity<>(list, HttpStatus.OK);

	}
	
//	@PutMapping("/test/{key}")
//	public ResponseEntity<?> test(
//			@RequestBody OrderVOExtend vo,
//			@PathVariable("key") String key)
//			throws JacksonUtilityException, Exception, FirebaseException {
//	
//		List<OrderInfoVO> list = orderService.getOrderInfo(vo.getId());
//		
//		for(OrderInfoVO listVO : list) {
//			String bizName = list.get(i).getBizName();
//			String path=bizName+'/'+key+'/'+list.get(i).getOrderdetailId();
//			Map map=Map_TO_Object.voToMap(list.get(i));
//			firebaseService.putOrder(path, map);
//		}
//		
////		Map<String, Object> map;
//		
//		
//		return new ResponseEntity<>( HttpStatus.OK);
//	}
	
	@PutMapping("/test/{key}")
	public ResponseEntity<?> test(
			@RequestBody OrderVOExtend vo,
			@PathVariable("key") String key)
			throws JacksonUtilityException, Exception, FirebaseException {
	
		List<OrderInfoVO> list = orderService.getOrderInfo(vo.getId());
		
		Map<String, Object> map=null;
		Map<String, Object> map2=new HashMap<>();
		map2.put("status", "ORD001");
		
		//path = "yuni_pizza/order_01/orderDetailId_01";
		//path = "유니네 피자의 오더 아이디(key)의 개별 오더(orderDetailId)";
		String bizName = "";
		String orderDetailId="";
		String orderOption="";
		String path="";
		String statusPath;
		
		for(OrderInfoVO listElement : list) {
			bizName = listElement.getBizName();
			orderDetailId = listElement.getOrderdetailId();
			orderOption = listElement.getOptName() != null ? listElement.getOptName().replaceAll(" " , ""):"없음";
			path=bizName+'/'+key+'/'+orderDetailId+'/'+orderOption;
			map=Map_TO_Object.voToMap(listElement);
			firebaseService.putOrder(path, map);
			
			statusPath = bizName+'/'+key+"/status";
			firebaseService.putOrder(statusPath, map2);
		}
		
		return new ResponseEntity<>( HttpStatus.OK);
	}
}

