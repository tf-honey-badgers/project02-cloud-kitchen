package org.badgers.rest.customer.order.controller;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.badgers.rest.customer.order.firebase.FirebaseException;
import org.badgers.rest.customer.order.firebase.FirebaseResponse;
import org.badgers.rest.customer.order.firebase.JacksonUtilityException;
import org.badgers.rest.customer.order.service.CustOrderService;
import org.badgers.rest.customer.order.service.FireBaseService;
import org.badgers.rest.firebasetest.Order;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderVOExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;

@RestController
public class TestController {
	
	@Inject
	private FireBaseService service;
	
	@Setter(onMethod_ = { @Autowired })
	private CustOrderService orderService;
	
	@PostMapping("/test/firebase")
	public ResponseEntity<?> test (@RequestBody Order order) throws UnsupportedEncodingException, FirebaseException, JacksonUtilityException {
		
		System.out.println("======================================================================================");
		System.out.println(order);
		Map<String, Object> testmap = new LinkedHashMap<String, Object>();
		testmap.put("orderInfo111", order);
//		testmap.put("8888", order);
//		testmap.put("8888", order);
		
		FirebaseResponse response =service.test(testmap);
		response.getBody().get("name");
		System.out.println("------------------------------------------------------");
		System.out.println(response.getBody().get("name"));
		return new ResponseEntity<>( HttpStatus.OK);
		
	}

	@PostMapping("/test/tj/order")
	public ResponseEntity<?> orderTest (@RequestBody OrderVOExtend order) throws Exception{
		
		System.out.println("----------order-----------------");
		System.out.println(order);
		System.out.println("--------------------------------");
		
//		orderService.excuteOrder(order);
		List<OrderInfoVO> list = orderService.getOrderInfo(order.getId());
		System.out.println("--------list-----------------------");
		System.out.println(list.get(0));
		/*
		 * for(int i=0;i<order.getOrderDetails().length;i++) {
		 * System.out.println("=========["+i+"]번째 주문메뉴 ===============");
		 * System.out.println(order.getOrderDetails()[i].toString()); for(int j=0;
		 * j<order.getOrderDetails()[i].getOrderOptions().length;j++) {
		 * System.out.println("=========["+i+"]번째 주문메뉴의  "+j+" 번째 추가 옵션==============="
		 * );
		 * System.out.println(order.getOrderDetails()[i].getOrderOptions()[j].toString()
		 * ); } }
		 */
		
		
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	
	
}


/*
 * { "id": "order20190315", "custId": "yuni1010", "phone": "010-1111-8888",
 * "address": "경기도 고양시 일산동구 마두1동 백마마을 202동 집", "msg": "많이 주세요 배고파요",
 * "kitchenName": "종각점", "payAmt": 26000, "orderPayment": {
 * "id":"order20190315", "amount": 26000, "method": "kakaoPay" },
 * "orderDetails": [{ "id": "orderdetailid20190315", "menuId": "menu_1",
 * "menuName": "떡볶이", "menuPrice": 3000, "addOptionPrice": 0, "quantity": 1,
 * "totalAmt": 3000, "bizId": "biz_1", "bizName": "태주네 떡볶이", "requestMsg":
 * "매우매우맵게 해주세요", "orderId":"order20190315", "orderOptions": [{ "optId":
 * "opt_03", "optName": "매우매움", "optPrice": 0,
 * "orderDetailId":"orderdetailid20190315" }] }, { "id":
 * "orderdetailid20190315", "menuId": "menu_7", "menuName": "피자", "menuPrice":
 * 13000, "addOptionPrice": 6000, "quantity": 1, "totalAmt": 19000, "bizId":
 * "biz_3", "bizName": "유니네 피자", "requestMsg": "피클 많이 주십쇼",
 * "orderId":"order20190315", "orderOptions": [{ "optId": "opt_1", "optName":
 * "치즈크러스트", "optPrice": 2000, "orderDetailId":"orderdetailid20190315" }, {
 * "optId": "opt_3", "optName": "페퍼로니 추가", "optPrice": 3000,
 * "orderDetailId":"orderdetailid20190315" }, { "optId": "opt_22", "optName":
 * "올리브 추가", "optPrice": 1000, "orderDetailId":"orderdetailid20190315" } ] } ] }
 */
