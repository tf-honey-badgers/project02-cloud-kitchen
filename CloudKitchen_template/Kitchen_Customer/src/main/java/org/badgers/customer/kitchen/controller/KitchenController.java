package org.badgers.customer.kitchen.controller;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.badgers.customer.model.BizVOExtend;
import org.badgers.customer.model.CartVOExtend;
import org.badgers.customer.model.CommonCodeVO;
import org.badgers.customer.util.RestDomain;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/kitchen")
@Log4j
public class KitchenController {
	@Inject
	RestTemplate restTemplate;

/* 가게 정보 읽어서 view에 뿌리기 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/{bizId}/main", produces = "application/json")
	public ModelAndView readBizMain(
				ModelAndView mav,
				@PathVariable("bizId") String bizId,
				@RequestParam(value = "auth", required = false) String auth,
				@RequestParam(value = "custId", required = false) String custId
			) {
		List<BizVOExtend> returnBiz = null;
		List<CartVOExtend> returnCart = null;
		String url = RestDomain.restDomain+"/kitchenbranch/bizinfo/" + bizId;
		
		ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, java.util.List.class); // 특정 가게의 메뉴 읽어오기
		returnBiz = responseEntity.getBody();

		if(auth != null) {
			if(auth.equals("true")) {
				url = RestDomain.restDomain+"/cart/" + custId; // 현재 로그인되어 있는 사용자 ID를 사용
				ResponseEntity<List> readMenuFromCart = restTemplate.getForEntity(url, java.util.List.class); // 카트에서 특정 회원ID 가진 항목들 읽어오기
				returnCart = readMenuFromCart.getBody();
			}			
		}
		
		if(returnBiz != null) {
			log.info("readBizMain DONE!!!!!");
			mav.addObject("bizMember", returnBiz.get(0)); // 메뉴 정보를 model에 추가
			mav.addObject("cart", returnCart); // 카트 정보를 model에 추가
		} else {
			log.info("Failed to readBizMain. REST server may be offline.");
			mav.addObject("message", "Failed to read biz main data. REST server may be offline.");
		}		
		mav.setViewName("bizMenu");
		return mav;
	}

/* 자동완성용으로 키친 지점, 가게, 메뉴 정보 읽어오기 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/lists", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<Map<String, List>> getLists() {
		Map<String, List> returnVal = null;
		String url = RestDomain.restDomain+"/kitchenbranch/alllists";
		
		ResponseEntity<Map> responseEntity = restTemplate.getForEntity(url, Map.class); // 자동완성용, 키친 지점 리스트, 가게 리스트, 메뉴 리스트 읽어오기
		if(!responseEntity.getBody().isEmpty()) {
			returnVal = responseEntity.getBody();
		}	
		return new ResponseEntity<Map<String,List>>(returnVal, HttpStatus.OK);
	}
	
/* 검색 시 일치하는 가게 정보 가지고 검색결과 페이지로 넘어가기 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/search", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ModelAndView searchLists(ModelAndView mav, @ModelAttribute("query") String query) {
		List<BizVOExtend> returnVal = null;
		String urlSearch = RestDomain.restDomain+"/kitchenbranch/searchlists";
		List<CommonCodeVO> bizCatVal = null;
		String urlBizCat = RestDomain.restDomain+"/kitchenbranch/bizcodes";

		if(query.equals("")) { // query를 입력했는지 확인하기
			log.info("query is null");
			query = " ";
		}
		
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8"))); // 한글 처리
		ResponseEntity<List> responseEntity = restTemplate.postForEntity(urlSearch, query, List.class); // query에 일치하는 검색 결과 읽어오기
		ResponseEntity<List> responseBizCats = restTemplate.getForEntity(urlBizCat, List.class); // 사이드바용으로 가게 분류 (한식 등) 읽어오기
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