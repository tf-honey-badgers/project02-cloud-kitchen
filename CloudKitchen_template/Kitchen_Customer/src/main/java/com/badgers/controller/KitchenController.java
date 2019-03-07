package com.badgers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.badgers.service.KitchenService;

import lombok.Setter;

@Controller
public class KitchenController {
	
	@Setter(onMethod_ = { @Autowired })
	private KitchenService service;
}
