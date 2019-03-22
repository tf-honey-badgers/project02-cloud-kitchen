package org.badgers.business.menu.controller;

import java.util.List;
import java.util.Map;

import org.badgers.business.menu.service.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Setter(onMethod_ = { @Autowired })
	private MenuServiceImpl service;
	
	@Setter(onMethod_=@Autowired)
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)	
	public ModelAndView bizGetMenu(ModelAndView mav, @RequestParam("bizId") String bizId) {
//		System.out.println(bizId);
		try {
			String url = "http://localhost:80/";
			ResponseEntity<List> menuResponseEntity = restTemplate.getForEntity
					(url+"rest/kitchenbranch/bizinfo/"+bizId, List.class);
			List<?> menuVoEx = menuResponseEntity.getBody();
//			System.out.println(menuVoEx);
			mav.addObject("bizMenu", menuVoEx);
			mav.setViewName("menuupdate");
			return mav;

		}catch(Exception e){
			e.getStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/main/update", method=RequestMethod.GET)
	@ResponseBody
	public List<?> getMenuInfo(@RequestParam("mIdx") int mIdx) {
		
		try {
			String url = "http://localhost:80";
			ResponseEntity<List> menuResponseEntity = restTemplate.getForEntity
					(url+"rest/kitchenbranch/menuinfo/"+mIdx, List.class);
			
			List<?> menuOptVoEx = menuResponseEntity.getBody();
			return menuOptVoEx;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/main/menuupdate", method=RequestMethod.GET)
	@ResponseBody
	public int updateMenu(@RequestParam("updateMenu") String updateMenuInfo) {
		System.out.println(updateMenuInfo);
		
		try {
			System.out.println("MenuUpdate Front Controller1");
			String url = "http://localhost:80/rest";
			
			ResponseEntity<?> updateResponseEntity = restTemplate.getForEntity
					(url+"/bizmenu/menuupdate/"+updateMenuInfo, int.class);
			System.out.println("MenuUpdate Front Controller2");
			
			int result = (int) updateResponseEntity.getBody();
			return result;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		return 0;
		
	}
	
}
