package org.badgers.customer.kitchen.controller;

import java.util.List;

import javax.inject.Inject;

import org.badgers.customer.model.BizVOExtend;
import org.badgers.customer.model.CartVOExtend;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/kitchen")
@Log4j
public class KitchenController {
	
	@Inject
	RestTemplate restTemplate;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/{bizId}/main", produces = "application/json")
	public ModelAndView readBizMain(ModelAndView mav, @PathVariable("bizId") String bizId) {		
		log.info("Kitchen_Customer 메뉴 읽기...............................");
		
		List<BizVOExtend> returnBiz = null;
		List<CartVOExtend> returnCart = null;
		String url = "http://localhost:12007/rest/kitchenbranch/bizinfo/" + bizId;
		
		try {
			ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, java.util.List.class);
			returnBiz = responseEntity.getBody();
			
			log.info("Kitchen_Customer 카트 읽기");
			url = "http://localhost:12007/rest/cart/" + "tjtjtj"; // 현재 로그인되어 있는 사용자 ID를 사용
			ResponseEntity<List> readMenuFromCart = restTemplate.getForEntity(url, java.util.List.class);
			returnCart = readMenuFromCart.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(returnBiz != null) {
			log.info("readBizMain DONE!!!!!");
			mav.addObject("bizMember", returnBiz.get(0));
			mav.addObject("cart", returnCart);
		} else {
			log.info("Failed to readBizMain. REST server may be offline.");
			mav.addObject("message", "Failed to read biz main data. REST server may be offline.");
		}		
		mav.setViewName("bizMenu");
		return mav;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/cart/add", produces = "application/json")
	public ResponseEntity<List<CartVOExtend>> addCart(@RequestBody CartVOExtend cart) {
		log.info("Kitchen_Customer 카트 DB에 추가하기");
		
		List<CartVOExtend> returnVal = null;
		String url = "http://localhost:12007/rest/cart/";
		
		System.out.println(cart);
		
		try {
			ResponseEntity<String> addMenuToCart = restTemplate.postForEntity(url, cart, String.class);
			System.out.println(addMenuToCart);
			
			log.info("Kitchen_Customer 카트 읽어오기");
			url += cart.getCustId();
			ResponseEntity<List> readMenuFromCart = restTemplate.getForEntity(url, java.util.List.class);
			returnVal = readMenuFromCart.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(returnVal != null) {
			log.info("Finished adding selected menu to cart!!!!!");
		} else {
			log.info("Failed to add selected menu to cart.");
		}
		
		return new ResponseEntity<>(returnVal, HttpStatus.OK);
	}
}