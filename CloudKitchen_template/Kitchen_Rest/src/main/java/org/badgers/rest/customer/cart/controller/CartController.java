package org.badgers.rest.customer.cart.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.badgers.rest.customer.cart.service.CartService;
import org.badgers.rest.model.CartVoExtend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Setter(onMethod_ = { @Autowired })
	private CartService service;

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@PostMapping("/")
	public int addCart(@RequestBody CartVoExtend cart) {
		logger.info("Adding " + cart.getCustId() + "'s new item to the 'cart' & 'cart_detail' tables!");
		return 0;
	}
	
	@GetMapping("/{custId}")
	public List<CartVoExtend> readCart(@PathVariable("custId") String custId) {
		logger.info("Reading " + custId + "'s items from the 'cart' table!");
		return null;
	}
	
	@PutMapping("/")
	public int updateCart(@RequestBody CartVoExtend cart) {
		logger.info("Updating " + cart.getCustId() + "'s items in the 'cart' table!");
		return 0;
	}
	
	@DeleteMapping("/{custId}/{cartId}")
	public int deleteCart(@PathVariable("custId") String custId, @PathVariable("cartId") String cartId) {
		logger.info("Deleting " + custId + "'s item(s) from the 'cart' & 'cart_detail' tables!");
		return 0;
	}
}
