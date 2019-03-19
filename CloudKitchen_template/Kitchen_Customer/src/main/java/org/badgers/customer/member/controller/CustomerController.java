package org.badgers.customer.member.controller;

import org.badgers.customer.member.service.CustomerService;
import org.badgers.customer.model.CustomerVO;
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
public class CustomerController {
	
	@Setter(onMethod_ = { @Autowired })
	private CustomerService service;
	
	@GetMapping("/{id}")
	public ModelAndView readCustomerMember(ModelAndView mav, @PathVariable("id") String id) {
		
		CustomerVO returnVal = null;
		
		try {
			returnVal = service.readCustomerMember(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("이용자 개인정보 GET");
		System.out.println(returnVal);		
		
		mav.addObject("vo", returnVal);
		mav.setViewName("mypage");
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
}
