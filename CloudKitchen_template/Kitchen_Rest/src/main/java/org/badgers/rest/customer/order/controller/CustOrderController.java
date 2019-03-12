package org.badgers.rest.customer.order.controller;


import org.badgers.rest.customer.order.service.CustOrderService;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
			service.excuteOrder();
		
		return "home";
	}
	
	@GetMapping(value="/{orderId}",
			produces= {
					MediaType.APPLICATION_JSON_UTF8_VALUE,
					MediaType.APPLICATION_XHTML_XML_VALUE
			})
	public OrderInfoVO getOrderInfo(
			@PathVariable("orderId") String orderId
			) throws Exception{
		System.out.println(orderId);
//		OrderInfoVO  vo= service.getOrderInfo();
//		System.out.println(vo.getId());
				return null;
		
	}
	
	
	@GetMapping(value="/test/{orderId}",
			produces= {
					MediaType.APPLICATION_JSON_UTF8_VALUE,
					MediaType.APPLICATION_XHTML_XML_VALUE
			})
	public OrderVO test(
			@PathVariable("orderId") String orderId
			) throws Exception{
		System.out.println(orderId);
		System.out.println("========================"+service.test(orderId).getKitchenName());
				return service.test(orderId);
		
	}
	
	@GetMapping(value="/tj/test/{orderId}")
	public int testInsertOrder(
			@PathVariable("orderId") String orderId
			) {
		System.out.println("tj의 orderID"+orderId);
		
		
		return 0;
	}
	
	
}
