package org.badgers.customer.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String home() {
		logger.info("Kitchen Customer Domain online");
		
		return "main";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String aboutUs() {		
		return "about";
	}	
	
	@RequestMapping(value = "/fcmtest", method = RequestMethod.GET)
	public String fcmtest() {		
		return "androidTest";
	}	
}
