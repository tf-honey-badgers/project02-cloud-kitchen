package org.badgers.rest.business.menu.controller;

import java.util.List;

import org.badgers.rest.business.menu.service.MenuService;
import org.badgers.rest.model.MenuCatVOExtend;
import org.badgers.rest.model.MenuOptionClVOExtend;
import org.badgers.rest.model.MenuOptionVOExtend;
import org.badgers.rest.model.MenuVOExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;

@RestController
@RequestMapping("/bizmenu")
public class MenuController {
	
	@Setter(onMethod_ = { @Autowired })
	private MenuService service;
	
	@RequestMapping("/addmenu")
	@ResponseBody
	public int addMenu(MenuCatVOExtend menuCatVoEx,MenuVOExtend menuVoEx,
			MenuOptionClVOExtend menuOptClVoEx,MenuOptionVOExtend menuOptVoEx) {
		
		return  service.addMenuCat(menuCatVoEx,menuVoEx,menuOptClVoEx,menuOptVoEx);
	}
	
	@RequestMapping("/deletemenu")
	@ResponseBody
	public int deleteMenu(@RequestParam("menuIdx") int menuIdx) {
		return service.deleteMenu(menuIdx);
	}
	
	@RequestMapping("/deleteMenuOpt")
	@ResponseBody
	public int deleteMenuOpt(@RequestParam("menuOptIdx") int menuOptIdx) {
		return service.deleteMenuOpt(menuOptIdx);
	}
	
	@RequestMapping("/addOnlyMenu")
	@ResponseBody
	public int addOnlyMenu(MenuCatVOExtend menuCatVoEx,MenuVOExtend menuVoEx) {
		return service.addOnlyMenu(menuCatVoEx, menuVoEx);
	}
	
	@RequestMapping("/addOnlyOpt")
	@ResponseBody
	public int addOnlyOpt(@RequestParam("menuIdx") int menuIdx, MenuVOExtend menuVoEx,
			MenuOptionClVOExtend menuOptClVoEx) {
		return  service.addOnlyOpt(menuIdx, menuVoEx,menuOptClVoEx);
	}
}
