package org.badgers.customer.order.controller;


import javax.servlet.http.HttpSession;

import org.badgers.customer.model.OrderVOExtend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class PaymentController {

	@RequestMapping("/orderinfo")
	public String orderInfo(HttpSession session, Model model) {
		
		/* 테스트용 */
		session.setAttribute("id", "TJ");
		session.setAttribute("phone", "01011112222");
		session.setAttribute("address", "고양시 우리집");
		/* --- */
		
		return "order_1_orderinfo";
	}
	
	@RequestMapping("/payment")
	public String payment(HttpSession session, OrderVOExtend vo) {
		
		session.setAttribute("OrderVOExtend", vo);
		
		return "order_2_payment";
	}
	
	@RequestMapping("/confirm")
	public String confirm(HttpSession session, OrderVOExtend vo) {
		vo.mergeOrderVO((OrderVOExtend)session.getAttribute("OrderVOExtend"));
		
		System.out.println(vo);
		return "order_3_confirm";
	}
}
