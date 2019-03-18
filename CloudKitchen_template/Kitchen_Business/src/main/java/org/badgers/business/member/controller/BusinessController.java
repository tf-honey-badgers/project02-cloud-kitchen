package org.badgers.business.member.controller;

import org.badgers.business.member.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Setter;

@Controller
@RequestMapping("/member")
public class BusinessController {

	@Setter(onMethod_ = { @Autowired })
	private BusinessService service;
	
	@GetMapping("/{bizId}")
	public void readBizMember(@PathVariable("bizId") String bizId) {
		try {
			service.readBizMember(bizId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("done");
	}
}
