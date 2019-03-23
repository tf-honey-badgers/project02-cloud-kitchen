package org.badgers.rest.customer.cart.controller;

import java.util.List;

import org.badgers.rest.customer.cart.service.CartService;
import org.badgers.rest.model.CartVOExtend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Setter(onMethod_ = { @Autowired })
	private CartService service;

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@PostMapping("/")
	public ResponseEntity<String> addCart(@RequestBody CartVOExtend cart) {
		logger.info("Adding " + cart.getCustId() + "'s new item to the 'cart' & 'cart_detail' tables!");
		int result = 0;
		String returnVal = "";
		
		System.out.println("출력하기 : " + cart);
			
		try {
			result = service.addCart(cart);
			returnVal = String.valueOf(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info(returnVal + "개 행을 추가했습니다!");
		return new ResponseEntity<String>(returnVal, HttpStatus.OK);
	}
	
	@GetMapping("/{custId}")
	public ResponseEntity<List<CartVOExtend>> readCart(@PathVariable("custId") String custId) {
		logger.info("Reading " + custId + "'s items from the 'cart' table!");
		List<CartVOExtend> returnVal = null;
		
		try {
			returnVal = service.readCart(custId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(CartVOExtend value : returnVal) {
			logger.info(value.toString());			
		}
		
		return new ResponseEntity<>(returnVal, HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Integer> updateCart(@RequestBody CartVOExtend cart) {
		logger.info("Updating " + cart.getCustId() + "'s items in the 'cart' table!");
		int returnVal = 0;
		
		try {
			returnVal = service.updateCart(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info(returnVal + "개 행을 수정했습니다!");
		return new ResponseEntity<>(returnVal, HttpStatus.OK);
	}
	
	// 장바구니 항목 하나만 삭제 (i.e. 장바구니의 특정 custId의 항목 중 특정 cartId를 가진 하나의 항목만 삭제한다)
	@DeleteMapping("/{custId}/{cartId}")
	public ResponseEntity<Integer> deleteCart(@PathVariable("custId") String custId, @PathVariable("cartId") String cartId) {
		logger.info("Deleting " + custId + "'s item(s) from the 'cart' & 'cart_detail' tables!");
		int returnVal = 0;
		
		try {
			returnVal = service.deleteCart(custId, cartId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info(returnVal + "개 행을 삭제했습니다!");
		return new ResponseEntity<>(returnVal, HttpStatus.OK);
	}
	
	// 장바구니 항목 전체 삭제 (i.e. 장바구니의 특정 custId의 항목을 모두 삭제)
	@DeleteMapping("/{custId}")
	public ResponseEntity<Integer> deleteAllCart(@PathVariable("custId") String custId) {
		logger.info("Deleting " + custId + "'s item(s) from the 'cart' & 'cart_detail' tables!");
		int returnVal = 0;
		
		try {
			returnVal = service.deleteCart(custId, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info(returnVal + "개 행을 삭제했습니다!");
		return new ResponseEntity<>(returnVal, HttpStatus.OK);
	}

}