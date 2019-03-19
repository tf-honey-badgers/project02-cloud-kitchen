package org.badgers.customer.member.controller;

import org.badgers.customer.member.service.CustomerService;
import org.badgers.customer.model.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	// 조회
	@GetMapping("/{id}")
	public ModelAndView readCustomer(ModelAndView mav, @PathVariable("id") String id) {
		
		CustomerVO returnVal = null;
		
		try {
			returnVal = service.readCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("이용자 개인정보 GET");
		System.out.println(returnVal);		
		
		mav.addObject("customer", returnVal);
		mav.setViewName("mypage");
		
		return mav;
	}
	
	// 로그인
	@PostMapping("/")
	public ModelAndView login(ModelAndView mav, @RequestBody CustomerVO customer) {
		
		String msg = "";
		
		try {
			msg = service.login(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(msg == "PW_BAD") {
			msg = "비밀번호가 틀렸습니다.";
		} else if(msg == "NO_ID") {
			msg = "존재하지 않는 아이디입니다.";
		} else if(msg == "SERVER_ERROR") {
			msg = "서버에 에러가 발생했습니다. 조금 있다가 다시 시도해주세요.";
		} else {
			// 로그인을 유지하기 위한 쿠키 생성
			msg = "성공적으로 로그인했습니다.";
		}

		mav.addObject("msg", msg);
		
		return mav;
	}
	
	@PostMapping("/{id}/modify")
	public ModelAndView updateCustomer(ModelAndView mav, @RequestBody CustomerVO customer) {
			System.out.println(customer);
		
		try {
			service.updateCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("updateBizMember DONE!!!!!");
		
		mav.setViewName("mypage");
		
		return mav;
		
		
		
	}
	
	
	
	
	
	
}
