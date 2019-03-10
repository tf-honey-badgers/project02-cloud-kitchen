package org.badgers.rest.business.menu.controller;

import org.badgers.rest.business.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Setter;

@Controller
public class MenuController {
	
	@Setter(onMethod_ = { @Autowired })
	private MenuService service;
}
