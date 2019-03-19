package org.badgers.business.member.controller;

import org.badgers.business.member.service.BusinessService;
import org.badgers.business.model.BizMemberVOExtend;
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
public class BusinessController {

	@Setter(onMethod_ = { @Autowired })
	private BusinessService service;
	
	@GetMapping("/{bizId}")
	public ModelAndView readBizMember(ModelAndView mav, @PathVariable("bizId") String bizId) {
		
		BizMemberVOExtend returnVal = null;
		
		try {
			returnVal = service.readBizMember(bizId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(returnVal);
		
		if(returnVal != null) { log.info("readBizMember DONE!!!!!"); }
		else {
			log.info("Failed to readBizMember. REST server may be offline.");
			mav.addObject("message", "Failed to read biz member data. REST server may be offline.");
		}
		
		mav.addObject("bizMember", returnVal);
		mav.setViewName("mypage");
		
		return mav;
	}
	
	// pw, account, info, minAmt, bizLiveStrm 수정 가능!
	@PostMapping("/{bizId}/modify")
	public ModelAndView updateBizMember(ModelAndView mav, @RequestBody BizMemberVOExtend bizMember) {
		
		System.out.println(bizMember);
		
		try {
			service.updateBizMember(bizMember);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("updateBizMember DONE!!!!!");
		
		mav.setViewName("mypage");
		
		return mav;
	}
	
	@PostMapping("/")
	public ModelAndView login(ModelAndView mav, @RequestBody BizMemberVOExtend bizMember) {
		
		String msg = "";
		
		try {
			msg = service.login(bizMember);
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
}
