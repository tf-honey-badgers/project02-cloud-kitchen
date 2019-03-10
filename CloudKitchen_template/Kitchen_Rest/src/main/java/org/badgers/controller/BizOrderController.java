package org.badgers.controller;

import org.badgers.service.BizOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Setter;

@Controller
public class BizOrderController {

	@Setter(onMethod_ = { @Autowired })
	private BizOrderService service;
}
