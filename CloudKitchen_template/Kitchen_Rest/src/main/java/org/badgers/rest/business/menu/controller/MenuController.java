package org.badgers.rest.business.menu.controller;

import java.util.List;

import org.badgers.rest.business.menu.service.MenuService;
import org.badgers.rest.model.MenuCatVOExtend;
import org.badgers.rest.model.MenuOptionClVOExtend;
import org.badgers.rest.model.MenuOptionVOExtend;
import org.badgers.rest.model.MenuVOExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;

@RestController
@RequestMapping("/bizmenu")
public class MenuController {
	
	@Setter(onMethod_ = { @Autowired })
	private MenuService service;
	
	@RequestMapping("/addmenucat")
	@ResponseBody
	public int addMenuCat(MenuCatVOExtend menuCatVoEx,MenuVOExtend menuVoEx,
			List<MenuOptionClVOExtend> menuOptClVoEx,List<MenuOptionVOExtend> menuOptVoEx) {

		System.out.println(menuCatVoEx);
		System.out.println(menuVoEx);
		System.out.println(menuOptClVoEx);
		System.out.println(menuOptVoEx);
		
		 return  service.addMenuCat(menuCatVoEx,menuVoEx,menuOptClVoEx,menuOptVoEx);
	}
}
