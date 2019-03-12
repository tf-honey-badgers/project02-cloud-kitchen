package org.badgers.rest.customer.cart.controller;

import java.util.List;

import org.badgers.rest.customer.cart.service.CartService;
import org.badgers.rest.model.CartVoExtend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;

@RestController
public class CartController {
	
	@Setter(onMethod_ = { @Autowired })
	private CartService service;

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@PostMapping("/cart")
	public int addCart(@RequestBody CartVoExtend cart) {
		logger.info("Adding " + cart.getCustId() + "'s new item to the 'cart' & 'cart_detail' tables!");
		int returnVal = 0;
			
		try {
			returnVal = service.addCart(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info(returnVal + "개 행을 추가했습니다!");
		return returnVal;
	}
	
	@GetMapping("/cart/{custId}")
	public List<CartVoExtend> readCart(@PathVariable("custId") String custId) {
		logger.info("Reading " + custId + "'s items from the 'cart' table!");
		List<CartVoExtend> returnVal = null;
		
		try {
			returnVal = service.readCart(custId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(CartVoExtend value : returnVal) {
			logger.info(value.toString());			
		}
		
		return returnVal;
	}
	
	@PutMapping("/cart")
	public int updateCart(@RequestBody CartVoExtend cart) {
		logger.info("Updating " + cart.getCustId() + "'s items in the 'cart' table!");
		int returnVal = 0;
		
		try {
			returnVal = service.updateCart(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info(returnVal + "개 행을 수정했습니다!");
		return returnVal;
	}
	
	@DeleteMapping("/cart/{custId}/{cartId}")
	public int deleteCart(@PathVariable("custId") String custId, @PathVariable("cartId") String cartId) {
		logger.info("Deleting " + custId + "'s item(s) from the 'cart' & 'cart_detail' tables!");
		int returnVal = 0;
		
		try {
			returnVal = service.deleteCart(custId, cartId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info(returnVal + "개 행을 삭제했습니다!");
		return returnVal;
	}
}