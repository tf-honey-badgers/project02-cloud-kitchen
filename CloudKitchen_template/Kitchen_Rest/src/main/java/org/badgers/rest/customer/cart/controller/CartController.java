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

/* cart테이블 & cart_detail테이블에 추가하기 */
	@PostMapping("/")
	public ResponseEntity<String> addCart(@RequestBody CartVOExtend cart) {
		int result = 0; // 몇 개 행을 수정했는지 표시하는 변수
		String returnVal = "";
			
		try {
			result = service.addCart(cart);
			returnVal = String.valueOf(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>(returnVal, HttpStatus.OK);
	}

/* 카트 정보 읽어오기 */
	@GetMapping(value = "/{custId}", produces="application/json")
	public ResponseEntity<List<CartVOExtend>> readCart(@PathVariable("custId") String custId) {
		List<CartVOExtend> returnVal = null;
		
		try {
			returnVal = service.readCart(custId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(CartVOExtend value : returnVal) {
			logger.info(value.toString());			
		}
		return new ResponseEntity<List<CartVOExtend>>(returnVal, HttpStatus.OK);
	}

/* 카트 정보 업데이트하기 */
	@PutMapping("/")
	public ResponseEntity<Integer> updateCart(@RequestBody CartVOExtend cart) {
		int returnVal = 0; // 몇 개 행을 수정했는지 표시하는 변수
		
		try {
			returnVal = service.updateCart(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(returnVal, HttpStatus.OK);
	}
	
/* 장바구니 항목 하나만 삭제 (i.e. 장바구니의 특정 custId의 항목 중 특정 cartId를 가진 하나의 항목만 삭제한다) */
	@DeleteMapping("/{custId}/{cartId}")
	public ResponseEntity<Integer> deleteCart(@PathVariable("custId") String custId, @PathVariable("cartId") String cartId) {
		int returnVal = 0; // 몇 개 행을 수정했는지 표시하는 변수
		
		try {
			returnVal = service.deleteCart(custId, cartId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(returnVal, HttpStatus.OK);
	}
	
/* 장바구니 항목 전체 삭제 (i.e. 장바구니의 특정 custId의 항목을 모두 삭제) */
	@DeleteMapping("/{custId}")
	public ResponseEntity<Integer> deleteAllCart(@PathVariable("custId") String custId) {
		int returnVal = 0; // 몇 개 행을 수정했는지 표시하는 변수
		
		try {
			returnVal = service.deleteCart(custId, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(returnVal, HttpStatus.OK);
	}	
}