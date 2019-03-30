package org.badgers.business.menu.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.badgers.business.menu.service.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value="/main/menuupdate", method=RequestMethod.POST, 
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int updateMenu(@RequestParam("updateMenu") String menuUpdateInfo) {
		System.out.println(menuUpdateInfo);
		int result = 0;
		try {
			System.out.println("MenuUpdate Front Controller1");
			String url = "http://localhost:80/rest/bizmenu/menuupdate";
	        
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

			HttpEntity entity = new HttpEntity(menuUpdateInfo, headers);
			
			ResponseEntity updateResponseEntity = restTemplate.postForEntity
					(url,entity,int.class);
			
			System.out.println("MenuUpdate Front Controller2");
			
			result = (int) updateResponseEntity.getBody();
			System.out.println(result);
			return result;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return 0;
		
	}
	
	
	@RequestMapping(value="/main/getMenuCat", method=RequestMethod.GET)
	@ResponseBody
	public List<?> getMenuCat(@RequestParam("bizId") String bizId) {
		System.out.println("FrontController : "+bizId);
		try {
			String url = "http://localhost:80";
			ResponseEntity<List> menuResponseEntity = restTemplate.getForEntity
					(url+"rest/bizmenu/getMenuCat/"+bizId, List.class);
			
			List<?> menuOptVoEx = menuResponseEntity.getBody();
			return menuOptVoEx;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value="/main/getComCode", method=RequestMethod.GET)
	@ResponseBody
	public List<?> getComCode() {
		try {
			String url = "http://localhost:80";
			ResponseEntity<List> menuResponseEntity = restTemplate.getForEntity
					(url+"rest/bizmenu/getComCode", List.class);
			
			List<?> menuComCode = menuResponseEntity.getBody();
			return menuComCode;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value="/main/insertMenu", method=RequestMethod.POST, 
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int insertMenu(@RequestParam("menuInfo") String menuInsertInfo) {
		int result = 0;
		try {
			String url = "http://localhost:80/rest/bizmenu/menuinsert";
	        
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

			HttpEntity entity = new HttpEntity(menuInsertInfo, headers);
			
			ResponseEntity updateResponseEntity = restTemplate.postForEntity
					(url,entity,int.class);
			
			System.out.println("MenuUpdate Front Controller2");
			
			result = (int) updateResponseEntity.getBody();
			System.out.println(result);
			return result;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return 0;
		
	}
	
	
	@RequestMapping(value="/main/deletemenu", method=RequestMethod.POST, 
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int deleteMenu(@RequestParam("menuId") String menuId) {
		System.out.println(menuId);
		int result = 0;
		try {
			System.out.println("MenuUpdate Front Controller1");
			String url = "http://localhost:80/rest/bizmenu/deletemenu";
	        
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

			HttpEntity entity = new HttpEntity(menuId, headers);
			
			ResponseEntity updateResponseEntity = restTemplate.postForEntity
					(url,entity,int.class);
			
			System.out.println("MenuUpdate Front Controller2");
			
			result = (int) updateResponseEntity.getBody();
			System.out.println(result);
			return result;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return 0;
		
	}
}
