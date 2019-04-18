package org.badgers.customer.common.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/common/error")
@Log4j
public class CommonErrorController {
	
	@GetMapping("/throwable")
	public String throwable (Model model) {
		
		model.addAttribute("msg","예외가 발생하였습니다");
		return "common/error";
	}
	@GetMapping("/exception")
	public String exception (Model model) {
		
		model.addAttribute("msg","예외가 발생하였습니다");
		return "common/error";
	}
	@GetMapping("/400")
	public String pageError400 (Model model) {
		
		model.addAttribute("msg","잘못된 요청입니다");
		return "common/error";
	}
	@GetMapping("/403")
	public String pageError403 (Model model) {
		
		model.addAttribute("msg","접근이 금지외었습니다");
		return "common/error";
	}
	@GetMapping("/404")
	public String pageError404 (Model model) {
		log.info("404존재하지 않는 페이지");
		model.addAttribute("msg","요청하신 페이지는 존재하지 않습니다 ");
		return "common/error";
	}
	@GetMapping("/405")
	public String pageError405 (Model model) {
		
		model.addAttribute("msg","예외가 발생하였습니다");
		return "common/error";
	}
	@GetMapping("/500")
	public String pageError500 (Model model) {
		
		model.addAttribute("msg","서버에 오류가 발생하였습니다");
		return "common/error";
	}
	@GetMapping("/503")
	public String pageError503 (Model model) {
		
		model.addAttribute("msg","서비스를 사용할 수 없습니다");
		return "common/error";
	}

}
