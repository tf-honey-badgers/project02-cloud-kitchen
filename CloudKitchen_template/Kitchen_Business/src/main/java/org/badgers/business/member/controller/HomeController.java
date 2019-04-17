package org.badgers.business.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@GetMapping("/main")
	public ModelAndView goMain(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
}
