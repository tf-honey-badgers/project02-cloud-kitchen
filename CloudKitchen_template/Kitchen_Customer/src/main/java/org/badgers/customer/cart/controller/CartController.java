package org.badgers.customer.cart.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.badgers.customer.model.CartVOExtend;
import org.badgers.customer.util.RestDomain;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/cart")
@Log4j
public class CartController {
	@Inject
	RestTemplate restTemplate;	
	

/* 카트에 메뉴 추가하기 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/add", produces = "application/json")
	public ResponseEntity<List<CartVOExtend>> addCart(@RequestBody CartVOExtend cart) {		
		List<CartVOExtend> returnVal = null;
		String url = RestDomain.restDomain+"/cart/";
		
		restTemplate.postForEntity(url, cart, String.class); // 카트에 메뉴 추가하기
		url += cart.getCustId();
		ResponseEntity<List> readMenuFromCart = restTemplate.getForEntity(url, java.util.List.class); // 특정 회원ID를 가진 카트 항목들 읽어오기
		returnVal = readMenuFromCart.getBody();

		if(returnVal != null) { log.info("Finished adding selected menu to cart!!!!!"); }
		else { log.info("Failed to add selected menu to cart."); }
		
		return new ResponseEntity<>(returnVal, HttpStatus.OK);
	}
	
/* 카트에서 회원ID & 카트ID 사용해서 삭제하기 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "/delete", produces = "application/json")
	public ResponseEntity<List<CartVOExtend>> deleteCart(@RequestBody Map<String, Object> req) {
		// 삭제할 회원ID & 카트ID들 읽어오기
		String custId = (String) req.get("custId");
		List cartIds = (List) req.get("cartIds");
		
		List<CartVOExtend> returnVal = null;
		String url = RestDomain.restDomain+"/cart/" + custId;
		
		for(int i = 0; i < cartIds.size(); i++) {
			String tempUrl = url + "/" + cartIds.get(i);
			restTemplate.delete(tempUrl); // 카트 항목을 하나씩 삭제
		}
		
		ResponseEntity<List> readMenuFromCart = restTemplate.getForEntity(url, java.util.List.class);
		returnVal = readMenuFromCart.getBody();
		
		if(returnVal != null) { log.info("Finished deleting from cart!!!!!"); }
		else { log.info("Failed to delete from cart."); }
		
		return new ResponseEntity<>(returnVal, HttpStatus.OK);
	}
}