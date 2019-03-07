package com.badgers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.badgers.service.BusinessService;

import lombok.Setter;

@Controller
public class BusinessController {

	@Setter(onMethod_ = { @Autowired })
	private BusinessService service;
}
