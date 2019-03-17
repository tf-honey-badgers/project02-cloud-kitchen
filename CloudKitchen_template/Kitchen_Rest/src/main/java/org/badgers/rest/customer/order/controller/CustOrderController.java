package org.badgers.rest.customer.order.controller;

import java.util.List;

import org.badgers.rest.customer.order.service.CustOrderService;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderVO;
import org.badgers.rest.model.OrderVOExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/rest/order")
public class CustOrderController {

	@Setter(onMethod_ = { @Autowired })
	private CustOrderService service;

	@PostMapping("/")
	public ResponseEntity<?> orderTest(@RequestBody OrderVOExtend order) throws Exception {
		log.info("결과 {} : {}", 1 ,2 );
		System.out.println("----------order-----------------");
		System.out.println(order);
		System.out.println("--------------------------------");

		service.excuteOrder(order);
		List<OrderInfoVO> list = service.getOrderInfo(order.getId());
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
		
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

//	{ "id": "order201903154", "custId": "jong123", "phone": "010-1111-8888",
//	  "address": "인천 간석동 현대홈타운 종현이네집", "msg": "많이 주세요 배고파요", "kitchenName": "종각점",
//	  "payAmt": 30000, "orderPayment": { "id": "order201903154", "amount": 30000,
//	  "method": "kakaoPay" }, "orderDetails": [{ "id": "orderdetailid20190323",
//	  "menuId": "menu_1", "menuName": "떡볶이", "menuPrice": 3000, "addOptionPrice":
//	  0, "quantity": 1, "totalAmt": 3000, "bizId": "biz_1", "bizName": "태주네 떡볶이",
//	  "requestMsg": "매우매우맵게 해주세요", "orderId": "order201903154", "orderOptions": [{
//	  "optId": "opt_03", "optName": "매우매움", "optPrice": 0, "orderDetailId":
//	  "orderdetailid20190323" }] }, { "id": "orderdetailid20190324", "menuId":
//	  "menu_7", "menuName": "피자", "menuPrice": 13000, "addOptionPrice": 6000,
//	  "quantity": 1, "totalAmt": 19000, "bizId": "biz_3", "bizName": "유니네 피자",
//	  "requestMsg": "피클 많이 주십쇼", "orderId": "order201903154", "orderOptions": [{
//	  "optId": "opt_1", "optName": "치즈크러스트", "optPrice": 2000, "orderDetailId":
//	  "orderdetailid20190324" }, { "optId": "opt_3", "optName": "페퍼로니 추가",
//	  "optPrice": 3000, "orderDetailId": "orderdetailid20190324" }, { "optId":
//	  "opt_22", "optName": "올리브 추가", "optPrice": 1000, "orderDetailId":
//	  "orderdetailid20190324" } ] }, { "id": "orderdetailid20190325", "menuId":
//	  "menu_3", "menuName": "모듬 튀김", "menuPrice": 8000, "addOptionPrice": 0,
//	  "quantity": 1, "totalAmt": 8000, "bizId": "biz_1", "bizName": "태주네 떡볶이",
//	  "requestMsg": "뜨겁게", "orderId": "order201903154", "orderOptions": [] } ] }

}
