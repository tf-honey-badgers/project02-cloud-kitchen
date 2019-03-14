package org.badgers.rest.customer.order.controller;


import java.util.List;

import org.badgers.rest.customer.order.service.CustOrderService;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;

@RestController
@RequestMapping("/rest/order")
public class CustOrderController {
	
	@Setter(onMethod_ = { @Autowired })
	private CustOrderService service;
	
	
	@RequestMapping(value = "/myhome", method = RequestMethod.GET)
	public String test() throws Exception{
//			service.excuteOrder();
		
		return "home";
	}
	
	@GetMapping(value="/{orderId}",
			produces= {
					MediaType.APPLICATION_JSON_UTF8_VALUE,
					MediaType.APPLICATION_XHTML_XML_VALUE
			})
	public List<OrderInfoVO> getOrderInfo(
			@PathVariable("orderId") String orderId
			) throws Exception{
		System.out.println(orderId);
		List<OrderInfoVO>  list = service.getOrderInfo(orderId);
//		System.out.println(vo.getId());
				return list;
		
	}
	
	
	@GetMapping(value="/test/order/{orderId}",
			produces= {
					//MediaType.APPLICATION_JSON_UTF8_VALUE,
					//MediaType.APPLICATION_XHTML_XML_VALUE
			})
	public OrderVO test(
			@PathVariable("orderId") String orderId
			) throws Exception{
		System.out.println(orderId);
		System.out.println("========================"+service.getOrderWithOrderId(orderId).getKitchenName());
				return service.getOrderWithOrderId(orderId);
		
	}
	

	
	@GetMapping(value="/test/order")
	public ResponseEntity<List<OrderVO>>  getOrder(String orderId){
		return new ResponseEntity<>(service.getOrder(orderId), HttpStatus.OK);
	}
	
	@PostMapping("/test/yuni")
	public ResponseEntity<?>  test1(@RequestBody OrderVO vo ){
		System.out.println(vo);
		
		return new ResponseEntity<>(service.getOrder("order_1"), HttpStatus.OK);
	}
	
	

	
	
}
