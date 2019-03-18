package org.badgers.business.menu.controller;

import java.util.List;

import org.badgers.business.menu.service.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Setter(onMethod_ = { @Autowired })
	private MenuServiceImpl service;
	
	@RequestMapping(value="/{bizId}", method=RequestMethod.GET)
	@ResponseBody
	public List<?> bizGetMenu(ModelAndView mav, @PathVariable("bizId") String bizId) {
		System.out.println(bizId);
//		mav.addObject("bizMenu", service.bizGetMenu(bizId));
		return service.bizGetMenu(bizId);
	}
	
}
