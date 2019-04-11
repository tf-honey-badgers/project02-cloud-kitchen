package org.badgers.rest.customer.fcm.controller;

import org.badgers.rest.customer.fcm.service.CustFcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CustFcmController {
	@Autowired private CustFcmService service;
	
	public void updateFcmToken() {
		
	}
	
	
	
	
	
}
