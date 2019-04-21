package org.badgers.customer.order.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.badgers.customer.model.CartVOExtend;
import org.badgers.customer.model.OrderVOExtend;
import org.badgers.customer.order.service.PaymentService;
import org.badgers.customer.util.RestDomain;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/order")
@SessionAttributes("order")
@Log4j
public class PaymentController {

	@Inject
	RestTemplate restTemplate;
	@Inject
	PaymentService kakaoservice;

	
	//pre :
	@SuppressWarnings("rawtypes")
	@PostMapping("/orderinfo")
	public ModelAndView orderInfo(int[] selectedCart, ModelAndView mv) {
		String url = RestDomain.restDomain+"/cust/order/orderinfo";

		log.info("::::::::::::::::::::::::::::::selectCart의 내용:::::::::::::::::::::::::::::::::::::::::");
//		for(int i:selectedCart) {
//			System.out.println(i);
//		}
		log.info("::::::::::::::::::::::::::::::;;;;;;;;;;;:::::::::::::::::::::::::::::::::::::::::");
		
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
	@SuppressWarnings("rawtypes")
	@PostMapping("/payready")
	public String payReady(@ModelAttribute("order") OrderVOExtend order) {
		
		
		HttpEntity<MultiValueMap<String, String>> request= kakaoservice.kakaopay(order);
		ResponseEntity<Map> response = restTemplate.exchange("https://kapi.kakao.com/v1/payment/ready", HttpMethod.POST, request, Map.class);
		Map kakaoRes = response.getBody();
		log.info("..................카카오 페이...........................");
		log.info(kakaoRes);
        String url= (String) kakaoRes.get("next_redirect_pc_url");
        return "redirect:"+url;
	}
	//post : 
	
	@RequestMapping("/confirm")
	public String confirm() {
		return "/order/order_3_confirm";
	}


	@GetMapping("payment/{payMethod}/{status}")
	public String succeedPayment(@PathVariable("status")String status, @ModelAttribute("order") OrderVOExtend order, RedirectAttributes rttr) {
		log.info("...............................payment/status...................");
		log.info(order);
		log.info("....................카카오페이 응답하라 1987....................");
		
		if(status.equals("success")) {
			log.info("............success");
			String url = RestDomain.restDomain+"/cust/order/"+order.getId();
			log.info(url);
			ResponseEntity<String> responses  = restTemplate.postForEntity(url,order, String.class);
			
			String orderconfirm = responses.getBody();
			log.info(orderconfirm);
			rttr.addFlashAttribute("orderconfirm", (String)orderconfirm);
			
			return "redirect:/order/confirm";
			
		}else if(status.equals("cancel")) {
		}else if(status.equals("fail")) {
		}
		
		return "redirect:/main";
	}
	
}
