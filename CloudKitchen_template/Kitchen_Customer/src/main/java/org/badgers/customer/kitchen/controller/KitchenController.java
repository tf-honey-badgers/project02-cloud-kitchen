package org.badgers.customer.kitchen.controller;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.badgers.customer.model.BizVOExtend;
import org.badgers.customer.model.CartVOExtend;
import org.badgers.customer.model.CommonCodeVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/kitchen")
@Log4j
public class KitchenController {
	
	@Inject
	RestTemplate restTemplate;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/{bizId}/main", produces = "application/json")
	public ModelAndView readBizMain(ModelAndView mav, @PathVariable("bizId") String bizId) {		
		log.info("Kitchen_Customer 메뉴 읽기...............................");
		
		List<BizVOExtend> returnBiz = null;
		List<CartVOExtend> returnCart = null;
		String url = "http://localhost/rest/kitchenbranch/bizinfo/" + bizId;
		
		try {
			ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, java.util.List.class);
			returnBiz = responseEntity.getBody();
			
			log.info("Kitchen_Customer 카트 읽기");
			url = "http://localhost/rest/cart/" + "tjtjtj"; // 현재 로그인되어 있는 사용자 ID를 사용
			ResponseEntity<List> readMenuFromCart = restTemplate.getForEntity(url, java.util.List.class);
			returnCart = readMenuFromCart.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(returnBiz != null) {
			log.info("readBizMain DONE!!!!!");
			mav.addObject("bizMember", returnBiz.get(0));
			mav.addObject("cart", returnCart);
		} else {
			log.info("Failed to readBizMain. REST server may be offline.");
			mav.addObject("message", "Failed to read biz main data. REST server may be offline.");
		}		
		mav.setViewName("bizMenu");
		return mav;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/lists", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<Map<String, List>> getLists() {
		log.info("Reading lists of kitchen branches, businesses, menus for the autocomplete");
		
		Map<String, List> returnVal = null;
		String url = "http://localhost/rest/kitchenbranch/alllists";
		
		ResponseEntity<Map> responseEntity = restTemplate.getForEntity(url, Map.class);
		if(!responseEntity.getBody().isEmpty()) {
			returnVal = responseEntity.getBody();
		}	
		log.info(returnVal);
		
		return new ResponseEntity<Map<String,List>>(returnVal, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/search", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ModelAndView searchLists(ModelAndView mav, @ModelAttribute("query") String query) {
		log.info("Searching lists of kitchen branches, businesses, menus");
		System.out.println(query);

		List<BizVOExtend> returnVal = null;
		String urlSearch = "http://localhost/rest/kitchenbranch/searchlists";
		List<CommonCodeVO> bizCatVal = null;
		String urlBizCat = "http://localhost/rest/kitchenbranch/bizcodes";

		if(query.equals("")) {
			log.info("query is null");
			query = " ";
		}
		
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		ResponseEntity<List> responseEntity = restTemplate.postForEntity(urlSearch, query, List.class);
		ResponseEntity<List> responseBizCats = restTemplate.getForEntity(urlBizCat, List.class);
		bizCatVal = responseBizCats.getBody();
		
		if(!responseEntity.getBody().isEmpty()) {
			log.info("Search successful!");
			returnVal = responseEntity.getBody();
			mav.addObject("searchResults", returnVal);
		} else {
			log.info("No matching search results");
			mav.addObject("message", "No search results. Try again with a different query.");
		}
		
		mav.addObject("query", query);
		mav.addObject("bizCat", bizCatVal);
		log.info(returnVal);
		mav.setViewName("searchList");
		
		return mav;
	}
}