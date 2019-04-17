package org.badgers.rest.business.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/sample/")
@Controller
public class SecurityTestController {
	
	@GetMapping("all")
	public String doAll() {
		log.info("do all can access everybody");
		return "/security/all";
	}
	
	@GetMapping("/member")
	public String doMember() {
		log.info("logined member");
		return "/security/member";
	}
	
	@GetMapping("/admin")
	public String doAdmin() {
		log.info("admin only");
		return "/security/admin";
	}
}
