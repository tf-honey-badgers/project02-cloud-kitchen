package com.badgers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.badgers.service.BizOrderService;

import lombok.Setter;

@Controller
public class BizOrderController {

	@Setter(onMethod_ = { @Autowired })
	private BizOrderService service;
}
