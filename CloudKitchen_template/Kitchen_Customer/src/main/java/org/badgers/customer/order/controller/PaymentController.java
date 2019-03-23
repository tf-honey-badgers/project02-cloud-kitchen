package org.badgers.customer.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class PaymentController {

	@RequestMapping("/orderinfo")
	public String orderInfo(Model model) {
		
		/* 테스트용 */
		model.addAttribute("id", "TJ");
		model.addAttribute("phone", "01011112222");
		model.addAttribute("address", "인천 남동구 우리집");
		/* --- */
		
		return "order_1_orderinfo";
	}
	
	@RequestMapping("/payment")
	public String payment() {
		return "order_2_payment";
	}
	
	@RequestMapping("/confirm")
	public String confirm() {
		return "order_3_confirm";
	}
}
