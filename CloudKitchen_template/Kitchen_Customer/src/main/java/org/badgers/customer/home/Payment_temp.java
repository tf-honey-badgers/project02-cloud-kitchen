package org.badgers.customer.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class Payment_temp {

	@RequestMapping("/payment")
	public String payment() {
		return "order_2_payment";
	}
	
	@RequestMapping("/confirm")
	public String confirm() {
		return "order_3_confirm";
	}
}
