package org.badgers.customer.order.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.badgers.customer.model.CartVOExtend;
import org.badgers.customer.model.OrderVOExtend;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/order")
@Log4j
public class PaymentController {

	@Inject
	RestTemplate restTemplate;

	@PostMapping("/orderinfo")
	public ModelAndView orderInfo(int[] selectedCart, ModelAndView mv) {
		String url = "http://127.0.0.1:80/rest/cust/order/orderinfo";
		
		ResponseEntity<CartVOExtend[]> response = restTemplate.postForEntity(url, selectedCart, CartVOExtend[].class);
		List cartList = Arrays.asList(response.getBody());
		
		mv.addObject("cartList", cartList);
		mv.setViewName("/order/order_1_orderinfo");
		
		return mv;
	}

	@RequestMapping("/payment")
	public ModelAndView payment(HttpSession session, OrderVOExtend vo, ModelAndView mv) {

		mv.addObject("Order", vo);
		mv.setViewName("/order/order_2_payment");
		
		return mv;
	}

	@PostMapping("/payready")
	public ModelAndView payReady(HttpSession session, String method, ModelAndView mv) {
		
		mv.addObject("method", method);
		mv.setViewName("redirect:/order/order_2_payment");
		
		return mv;
	}
	
	@RequestMapping("/confirm")
	public String confirm(HttpSession session, OrderVOExtend vo) {
		

		System.out.println(vo);
		return "/order/order_3_confirm";
	}

	@GetMapping("/payment/{payMethod}")
	public void payWithPayMethod(@PathVariable("payMethod") String method) {
		
	}

	@GetMapping("/kakao/success")
	public String succeedPayment() {

		log.info("카카오페이 결제 성공...");
		return "/order/order_3_confirm";
	}
	
}
