package org.badgers.rest.business.menu.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.badgers.rest.business.menu.service.MenuService;
import org.badgers.rest.model.MenuCatVOExtend;
import org.badgers.rest.model.MenuOptionClVOExtend;
import org.badgers.rest.model.MenuOptionVOExtend;
import org.badgers.rest.model.MenuVOExtend;
import org.mortbay.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
//	@RequestMapping("/updateMenu")
//	@ResponseBody
//	public int updateMenu(MenuVOExtend menuVoEx) {
//		return  service.updateMenuInfo(menuVoEx);
//	}
	
	@RequestMapping(value="/menuupdate",produces = "application/json;charset=UTF-8", method=RequestMethod.POST)	
	@Transactional
	@ResponseBody
//	public ResponseEntity menuUpdate(@RequestBody List updateMenuInfo){
	public ResponseEntity<?> menuUpdate(@RequestBody String updateMenuInfo){
		int result = service.updateMenuInfo(updateMenuInfo);

		if(result == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(result, HttpStatus.OK); 
//		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
}
