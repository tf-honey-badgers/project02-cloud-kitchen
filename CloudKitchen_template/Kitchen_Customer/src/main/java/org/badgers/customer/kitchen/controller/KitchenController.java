package org.badgers.customer.kitchen.controller;

import java.util.List;

import javax.inject.Inject;

import org.badgers.customer.model.BizVOExtend;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/{bizId}/main", produces="application/json")
	public ModelAndView readBizMain(ModelAndView mav, @PathVariable("bizId") String bizId) {		
		log.info("Kitchen_Customer 메뉴 읽기...............................");
		
		List<BizVOExtend> returnVal = null;
		String url = "http://localhost:12007/rest/kitchenbranch/bizinfo/" + bizId;
		
		try {
			ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, java.util.List.class);
			returnVal = responseEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(returnVal != null) {
			log.info("readBizMain DONE!!!!!");
			mav.addObject("bizMember", returnVal.get(0));
		}
		else {
			log.info("Failed to readBizMain. REST server may be offline.");
			mav.addObject("message", "Failed to read biz main data. REST server may be offline.");
		}		
		mav.setViewName("detail_page");
		
		return mav;
	}
}