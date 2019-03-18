package org.badgers.business.menu.controller;

import java.util.List;

import org.badgers.business.menu.service.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Setter(onMethod_ = { @Autowired })
	private MenuServiceImpl service;
	
	@RequestMapping("/{bizId}")
	@ResponseBody
	public List<?> bizGetMenu(@PathVariable("bizId") String bizId){
		return service.bizGetMenu(bizId);
	}
}
