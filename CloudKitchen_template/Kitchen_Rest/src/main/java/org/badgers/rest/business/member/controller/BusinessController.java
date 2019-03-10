package org.badgers.rest.business.member.controller;

import org.badgers.rest.business.member.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Setter;

@Controller
public class BusinessController {

	@Setter(onMethod_ = { @Autowired })
	private BusinessService service;
}
