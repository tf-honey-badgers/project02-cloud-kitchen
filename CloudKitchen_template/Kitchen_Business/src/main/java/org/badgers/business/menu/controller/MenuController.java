package org.badgers.business.menu.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.badgers.business.util.RestDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
	
	@Setter(onMethod_=@Autowired)
	private RestTemplate restTemplate;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/{bizId}/main", method=RequestMethod.GET)	
	public ModelAndView bizGetMenu(ModelAndView mav, @PathVariable("bizId") String bizId) {
		try { 
			String url =  RestDomain.restDomain;
			ResponseEntity<List> menuResponseEntity = restTemplate.getForEntity
					(url+"/kitchenbranch/bizinfo/"+bizId, List.class);
			List<?> menuVoEx = menuResponseEntity.getBody();
			mav.addObject("bizMenu", menuVoEx);
			mav.setViewName("menuupdate");
			return mav;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/main/update", method=RequestMethod.GET)
	@ResponseBody
	public List<?> getMenuInfo(@RequestParam("mIdx") int mIdx) {
		
		try {
			String url =  RestDomain.restDomain;
			ResponseEntity<List> menuResponseEntity = restTemplate.getForEntity
					(url+"/kitchenbranch/menuinfo/"+mIdx, List.class);
			
			List<?> menuOptVoEx = menuResponseEntity.getBody();
			return menuOptVoEx;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/main/menuupdate", method=RequestMethod.POST, 
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int updateMenu(@RequestParam("updateMenu") String menuUpdateInfo) {
		int result = 0;
		try {
			String url =  RestDomain.restDomain+"/bizmenu/menuupdate";
	        
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

			HttpEntity entity = new HttpEntity(menuUpdateInfo, headers);
			
			ResponseEntity updateResponseEntity = restTemplate.postForEntity
					(url,entity,int.class);
			
			result = (int) updateResponseEntity.getBody();
			return result;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return 0;
		
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/main/getMenuCat", method=RequestMethod.GET)
	@ResponseBody
	public List<?> getMenuCat(@RequestParam("bizId") String bizId) {
		try {
			String url =  RestDomain.restDomain;
			ResponseEntity<List> menuResponseEntity = restTemplate.getForEntity
					(url+"/bizmenu/getMenuCat/"+bizId, List.class);
			
			List<?> menuOptVoEx = menuResponseEntity.getBody();
			return menuOptVoEx;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		return null;
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/main/getComCode", method=RequestMethod.GET)
	@ResponseBody
	public List<?> getComCode() {
		try {
			String url =  RestDomain.restDomain;
			ResponseEntity<List> menuResponseEntity = restTemplate.getForEntity
					(url+"/bizmenu/getComCode", List.class);
			
			List<?> menuComCode = menuResponseEntity.getBody();
			return menuComCode;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		return null;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/main/insertMenu", method=RequestMethod.POST, 
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int insertMenu(@RequestParam("menuInfo") String menuInsertInfo) {
		int result = 0;
		try {
			String url =  RestDomain.restDomain+"/bizmenu/menuinsert";
	        
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

			HttpEntity entity = new HttpEntity(menuInsertInfo, headers);
			
			ResponseEntity updateResponseEntity = restTemplate.postForEntity
					(url,entity,int.class);
			
			result = (int) updateResponseEntity.getBody();
			return result;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return 0;
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/main/deletemenu", method=RequestMethod.POST, 
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int deleteMenu(@RequestParam("menuId") String menuId) {
		int result = 0;
		try {
			System.out.println("MenuUpdate Front Controller1");
			String url =  RestDomain.restDomain+"/bizmenu/deletemenu";
	        
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

			HttpEntity entity = new HttpEntity(menuId, headers);
			
			ResponseEntity updateResponseEntity = restTemplate.postForEntity
					(url,entity,int.class);
			
			System.out.println("MenuUpdate Front Controller2");
			
			result = (int) updateResponseEntity.getBody();
			return result;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return 0;
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/main/deletemenuopt", method=RequestMethod.GET, 
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int deleteMenuOpt(@RequestParam("menuOptId") int menuOptId) {
		int result = 0;
		try {
			String url =  RestDomain.restDomain+"/bizmenu/deletemenuopt";
	        
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

			HttpEntity entity = new HttpEntity(menuOptId, headers);
			
			ResponseEntity updateResponseEntity = restTemplate.postForEntity
					(url,entity,int.class);
			
			result = (int) updateResponseEntity.getBody();
			return result;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return 0;
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/main/insertmenucat", method=RequestMethod.GET, 
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int insertMenuCat(@RequestParam("insertMenuCat") String insertMenuCat) {
		int result = 0;
		System.out.println(insertMenuCat);
		try {
			String url =  RestDomain.restDomain+"/bizmenu/insertmenucat";
	        
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

			HttpEntity entity = new HttpEntity(insertMenuCat, headers);
			
			ResponseEntity updateResponseEntity = restTemplate.postForEntity
					(url,entity,int.class);
			
			result = (int) updateResponseEntity.getBody();
			return result;
			
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return 0;
		
	}

}
