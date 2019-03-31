package org.badgers.customer.order.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.badgers.customer.model.CartVOExtend;
import org.badgers.customer.model.OrderVOExtend;
import org.badgers.customer.order.service.PaymentService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/order")
@Log4j
public class PaymentController {

	@Inject
	RestTemplate restTemplate;
	@Inject
	PaymentService kakaoservice;

	
	//pre :
	@PostMapping("/orderinfo")
	public ModelAndView orderInfo(int[] selectedCart, ModelAndView mv) {
		String url = "http://127.0.0.1:80/rest/cust/order/orderinfo";
		
		ResponseEntity<CartVOExtend[]> response = restTemplate.postForEntity(url, selectedCart, CartVOExtend[].class);
		List cartList = Arrays.asList(response.getBody());
		
		mv.addObject("cartList", cartList);
		mv.setViewName("/order/order_1_orderinfo");
		
		return mv;
	}
	//post : cartList를 "cart"로 저장
	
	//pre : 
	@RequestMapping("/payment")
	public ModelAndView payment(OrderVOExtend vo, ModelAndView mv) {

		mv.addObject("order", vo);//사용자 번호, 주소, 요청 메세지
		mv.setViewName("/order/order_2_payment");
		
		return mv;
	}
	//post : 사용자 번호, 주소, 요청 메세지, cartExtendVO를 OrderExtendVO에 저장(OrderExtendVO.PaymentVO 제외): "order"
	//orderId, OrderDetailId, 사용자 정보 아직 안 함
	
	//pre : method(결제 방법)을 받고 PaymentVO를 만들어 OrderExtendVO 완성 "order"
	@PostMapping("/payready")
	public String payReady(HttpSession session) {
		OrderVOExtend vo = (OrderVOExtend)session.getAttribute("order");
		HttpEntity<MultiValueMap<String, String>> request= kakaoservice.kakaopay(vo);
		ResponseEntity<Map> response = restTemplate.exchange("https://kapi.kakao.com/v1/payment/ready", HttpMethod.POST, request, Map.class);
		Map kakaoRes = response.getBody();
        System.out.println(kakaoRes);
        String url= (String) kakaoRes.get("next_redirect_pc_url");
        return "redirect:"+url;
	}
	//post : 
	
	@RequestMapping("/confirm")
	public String confirm(OrderVOExtend vo) {
		
		
		System.out.println(vo);
		return "/order/order_3_confirm";
	}

	@GetMapping("/payment/{payMethod}")
	public void payWithPayMethod(@PathVariable("payMethod") String method) {
		
	}

	@GetMapping("payment/{payMethod}/success")
	public String succeedPayment() {

		log.info("카카오페이 결제 성공...");
		return "/order/order_3_confirm";
	}
	
}
