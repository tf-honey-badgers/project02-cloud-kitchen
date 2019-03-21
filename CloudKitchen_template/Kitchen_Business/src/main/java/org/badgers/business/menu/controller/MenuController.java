package org.badgers.business.menu.controller;

import java.util.List;

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
	
	@RequestMapping(value="/main/{bizId}", method=RequestMethod.GET)	
	public ModelAndView bizGetMenu(ModelAndView mav, @PathVariable("bizId") String bizId) {
		System.out.println(bizId);
		try {
			String url = "http://localhost:80/";
			ResponseEntity<List> menuResponseEntity = restTemplate.getForEntity
					(url+"rest/kitchenbranch/bizinfo/"+bizId, List.class);
			List<?> menuVoEx = menuResponseEntity.getBody();
			mav.addObject("bizMenu", menuVoEx);
			mav.setViewName("menuupdate");
			return mav;

		}catch(Exception e){
			e.getStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/main/update/{mIdx}", method=RequestMethod.GET)
	@ResponseBody
	public List<?> getMenuInfo(@PathVariable("mIdx") int mIdx) {
		
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
	
	@RequestMapping(value="/main/menuupdate", method=RequestMethod.POST)
	@ResponseBody
	public int updateMenu(@RequestParam("updateMenu") List<?> updateMenuInfo) {
		System.out.println(updateMenuInfo);
		
		try {
			String url = "http://localhost:80";
			ResponseEntity<?> menuResponseEntity = restTemplate.getForEntity
					(url+"rest/kitchenbranch/menuupdate/"+updateMenuInfo, List.class);
			
			int menuOptVoEx = (int) menuResponseEntity.getBody();
			return menuOptVoEx;

		}catch(Exception e){
			e.getStackTrace();
		}
		return 0;
		
	}
	
}
