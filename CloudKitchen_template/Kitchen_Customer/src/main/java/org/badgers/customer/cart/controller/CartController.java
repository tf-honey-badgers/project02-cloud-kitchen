package org.badgers.customer.cart.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.badgers.customer.model.CartVOExtend;
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/add", produces = "application/json")
	public ResponseEntity<List<CartVOExtend>> addCart(@RequestBody CartVOExtend cart) {
		log.info("Kitchen_Customer 카트 DB에 추가하기");
		
		List<CartVOExtend> returnVal = null;
		String url = "http://13.209.21.25/rest/cart/";
		
//		System.out.println(cart);
		
		try {
			ResponseEntity<String> addMenuToCart = restTemplate.postForEntity(url, cart, String.class);
//			System.out.println(addMenuToCart);
			
			log.info("Kitchen_Customer 카트 읽어오기");
			url += cart.getCustId();
			ResponseEntity<List> readMenuFromCart = restTemplate.getForEntity(url, java.util.List.class);
			returnVal = readMenuFromCart.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(returnVal != null) { log.info("Finished adding selected menu to cart!!!!!"); }
		else { log.info("Failed to add selected menu to cart."); }
		
		return new ResponseEntity<>(returnVal, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "/delete", produces = "application/json")
	public ResponseEntity<List<CartVOExtend>> deleteCart(@RequestBody Map<String, Object> req) {
		log.info("Kitchen_Customer 카트 DB에서 삭제하기");
		
		String custId = (String) req.get("custId");
		List cartIds = (List) req.get("cartIds");
		
		List<CartVOExtend> returnVal = null;
		String url = "http://13.209.21.25/rest/cart/" + custId;
		try {
			for(int i = 0; i < cartIds.size(); i++) {
				String tempUrl = url + "/" + cartIds.get(i);
				restTemplate.delete(tempUrl);
			}
			ResponseEntity<List> readMenuFromCart = restTemplate.getForEntity(url, java.util.List.class);
			returnVal = readMenuFromCart.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(returnVal != null) { log.info("Finished deleting from cart!!!!!"); }
		else { log.info("Failed to delete from cart."); }
		
		return new ResponseEntity<>(returnVal, HttpStatus.OK);
	}
	
}