package org.badgers.rest.customer.order.controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.badgers.rest.customer.cart.service.CartService;
import org.badgers.rest.customer.order.service.CustFireBaseService;
import org.badgers.rest.customer.order.service.CustOrderService;
import org.badgers.rest.customer.order.service.ToOrderAlarmVOService;
import org.badgers.rest.customer.order.service.ToOrderInfoForViewService;
import org.badgers.rest.firebase.FirebaseException;
import org.badgers.rest.firebase.JacksonUtilityException;
import org.badgers.rest.model.CartVOExtend;
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
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/cust/order")
@RequiredArgsConstructor
@Log4j
public class CustOrderController {

	private final CustFireBaseService firebaseService;
	private final CustOrderService orderService;
	private final CartService cartService;
	private final ToOrderAlarmVOService toOrderAlarmVOService;
	private final ToOrderInfoForViewService toOrderInfoForViewService;
	
	@PostMapping(value="/orderinfo")
	public ResponseEntity<?> showSelectedCart(@RequestBody int[] selected) throws Exception{
		
		log.info("===========Get 파라미터로 넘어오는 cart id들==========");
		log.info(selected.length);
		log.info("===========List==========");
//		List<HashMap<String, Object>> map = cartService.readSelectedCart(selected);
//		log.info(map);
		
		List<CartVOExtend> list = cartService.readSelectedCart(selected);
		log.info(list.toString());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{key}", produces="application/json; charset=utf-8")
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
		// 4. 사용자의 view에 넘겨줄 orderInfo map
		String jsonOrderInfoForView = toOrderInfoForViewService.toOrderInfoForView(list);
		
		// 5. 주문 완료 된 고객의 장바구니 delete
		cartService.deleteAllCart(vo.getCustId());
		
		
		return new ResponseEntity<>(jsonOrderInfoForView, HttpStatus.OK);

	}

}

