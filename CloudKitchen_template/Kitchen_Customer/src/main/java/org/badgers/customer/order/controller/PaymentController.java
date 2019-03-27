package org.badgers.customer.order.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.badgers.customer.model.OrderVOExtend;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.sun.tools.javac.util.List;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/order")
@Log4j
public class PaymentController {

	@Inject
	RestTemplate restTemplate;

	@RequestMapping("/orderinfo")
	public String orderInfo(HttpSession session, Model model) {

		/* 테스트용 */
		session.setAttribute("id", "TJ");
		session.setAttribute("phone", "01011112222");
		session.setAttribute("address", "고양시 우리집");
		/* --- */

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
		log.info("결제 방식 :" + method);
		//String returnUrl = "";
		String user_id = "yuni";
		String item_name = "피자";
		String partner_order_id = "order123";
		String total_amount = "12345";

		
		//rest가 integer 로 받아야 하는데 보낼떼 string 보내면 성공...
		// integer 로 담았더니 오히려 에러 남 
		/*
			java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String] with root cause
			java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
			at org.springframework.http.converter.FormHttpMessageConverter.writeForm(FormHttpMessageConverter.java:308)
			at org.springframework.http.converter.FormHttpMessageConverter.write(FormHttpMessageConverter.java:271)
			at org.springframework.http.converter.FormHttpMessageConverter.write(FormHttpMessageConverter.java:95)
			at org.springframework.web.client.RestTemplate$HttpEntityRequestCallback.doWithRequest(RestTemplate.java:955)


		*/
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add("cid", "TC0ONETIME");
		map.add("partner_order_id", partner_order_id);
		map.add("partner_user_id", user_id);
		map.add("item_name", item_name);
		map.add("quantity", "1");
		map.add("total_amount", total_amount);
		map.add("tax_free_amount", "0");
		map.add("approval_url", "http://localhost:3000/business/");
		map.add("fail_url", "http://localhost:3000/business/");
		map.add("cancel_url", "http://localhost:3000/business/");
		
		

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "e0d26cb3e1a4b577fce26f8828fc6a49");
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
		

		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
		// MultiValueMap response = restTemplate.postForObject("https://kapi.kakao.com/v1/payment/ready", request, MultiValueMap.class);
		//System.out.println(restTemplate.postForObject("https://kapi.kakao.com/v1/payment/ready", request, java.util.List.class));
		  ResponseEntity<Map> response = restTemplate.exchange("https://kapi.kakao.com/v1/payment/ready", HttpMethod.POST, request, Map.class);
	        Map readyResp = response.getBody();
	        System.out.println(readyResp);
		
	}

	@GetMapping("/kakao/success")
	public String succeedPayment() {

		log.info("카카오페이 결제 성공...");
		return "/order/order_3_confirm";
	}
}
