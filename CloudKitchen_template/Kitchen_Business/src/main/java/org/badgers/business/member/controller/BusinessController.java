package org.badgers.business.member.controller;

import org.badgers.business.member.service.BusinessService;
import org.badgers.business.model.BizMemberVOExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
public class BusinessController {

	@Setter(onMethod_ = { @Autowired })
	private BusinessService service;
	
	@GetMapping("/{bizId}")
	public ModelAndView readBizMember(@PathVariable("bizId") String bizId) {
		ModelAndView mav = new ModelAndView();
		
		BizMemberVOExtend returnVal = null;
		
		try {
			returnVal = service.readBizMember(bizId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("readBizMember DONE!!!!!");
		
		mav.addObject("bizMember", returnVal);
		mav.setViewName("mypage");
		
		return mav;
	}
}
