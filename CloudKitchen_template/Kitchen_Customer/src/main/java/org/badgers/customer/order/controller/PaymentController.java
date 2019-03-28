package org.badgers.customer.order.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.badgers.customer.model.CartVOExtend;
import org.badgers.customer.model.OrderVOExtend;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/order")
@Log4j
public class PaymentController {

	@Inject
	RestTemplate restTemplate;

	@RequestMapping("/orderinfo")
	public String orderInfo(@RequestBody int[] cartIds, HttpSession session, Model model) {
		String url = "http://127.0.0.1:80/rest/cust/order/orderinfo";
		
		log.info("cartIds.length");
		log.info(cartIds.length);
		
		ResponseEntity<List> response = restTemplate.postForEntity(url, cartIds, List.class);
		log.info("겟바리겟바리겟바리겟바리겟바리겟바리겟바리겟바리겟바리겟바리겟바리겟바리겟바리겟바리겟바리");
		log.info(response.getBody());
		List cartList = response.getBody();

		/* 테스트용 */
		session.setAttribute("id", "TJ");
		session.setAttribute("phone", "01011112222");
		session.setAttribute("address", "고양시 우리집");
		/* --- */
		
		model.addAttribute("cartList", cartList);
		
		return "/order/order_1_orderinfo";
	}

	@RequestMapping("/payment")
	public String payment(HttpSession session, OrderVOExtend vo) {

		session.setAttribute("OrderVOExtend", vo);

		return "/order/order_2_payment";
	}

	@RequestMapping("/confirm")
	public String confirm(HttpSession session, OrderVOExtend vo) {
		vo.mergeOrderVO((OrderVOExtend) session.getAttribute("OrderVOExtend"));

		System.out.println(vo);
		return "/order/order_3_confirm";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/payment/{payMethod}")
	public void payWithPayMethod(@PathVariable("payMethod") String method) {
		
	}

	@GetMapping("/kakao/success")
	public String succeedPayment() {

		log.info("카카오페이 결제 성공...");
		return "/order/order_3_confirm";
	}
}
