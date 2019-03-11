package org.badgers.rest.customer.cart.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.badgers.rest.customer.kitchen.service.KitchenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Setter;

@Controller
public class CartController {
	
//	@Setter(onMethod_ = { @Autowired })
//	private KitchenService service;

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		logger.info("The current server time is " + formattedDate);
		
		return "home";
	}
}
