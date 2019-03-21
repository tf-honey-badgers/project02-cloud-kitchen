package org.badgers.rest.business.menu.controller;

import java.util.List;

import org.badgers.rest.business.menu.service.MenuService;
import org.badgers.rest.model.MenuCatVOExtend;
import org.badgers.rest.model.MenuOptionClVOExtend;
import org.badgers.rest.model.MenuOptionVOExtend;
import org.badgers.rest.model.MenuVOExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
	
	@RequestMapping("/updateMenu")
	@ResponseBody
	public int updateMenu(MenuVOExtend menuVoEx) {
		return  service.updateMenuInfo(menuVoEx);
	}
	
	@RequestMapping("/updateMenuOpt")
	@ResponseBody
	public int updateMenuOpt(MenuOptionVOExtend menuOptVoEx) {
		return  service.updateMenuOptInfo(menuOptVoEx);
	}
	
	
//	@RequestMapping(value="/menuupdate/{updateMenu}")
//	@Transactional
////	public ResponseEntity<int> menuUpdate(@RequestParam("updateMenu") List<?> updateMenuInfo){
//	public ResponseEntity menuUpdate(@RequestParam("updateMenu") List<?> updateMenuInfo){
//		System.out.println(updateMenuInfo);
//		
//		int result = service.updateMenu(updateMenuInfo);
//		
//		if(result == 0) {
//			return new ResponseEntity(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity(result, HttpStatus.OK);
//	}
}
