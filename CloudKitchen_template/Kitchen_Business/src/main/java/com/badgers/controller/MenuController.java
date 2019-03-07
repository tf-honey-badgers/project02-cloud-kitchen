package com.badgers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.badgers.service.MenuService;

import lombok.Setter;

@Controller
public class MenuController {
	
	@Setter(onMethod_ = { @Autowired })
	private MenuService service;
}
