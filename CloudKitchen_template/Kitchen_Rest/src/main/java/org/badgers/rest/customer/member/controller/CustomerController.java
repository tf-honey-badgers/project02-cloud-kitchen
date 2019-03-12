package org.badgers.rest.customer.member.controller;

import org.badgers.rest.customer.member.service.CustomerService;
import org.badgers.rest.model.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController

@Log4j
public class CustomerController {
	
	
	@Autowired
	private CustomerService service;
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "/register";
	}
	
	// post 로 RequestMapping 역활
	@PostMapping(value = "/register", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody CustomerVo vo) {
		boolean result = service.register(vo);
		log.info("insert result : " + result);

		return result ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	
	@GetMapping(value = "/login", consumes = "application/json")
	public String login() {
		return "login/login";
	}
	
	
	
	
	
	
	
	
//	@RequestMapping(method = { RequestMethod.PUT,
//			RequestMethod.PATCH }, value = "/modify/{customer}", consumes = "application/json", produces = {
//					MediaType.TEXT_PLAIN_VALUE })
//	public ResponseEntity<String> modify(@RequestBody CustomerVo vo, @PathVariable("pw") String pw,@PathVariable("name") String name, @PathVariable("email") String email) {
//		log.info(vo);
//		vo.setPw(pw);
//		vo.setName(name);
//		vo.setEmail(email);
//		
//
//		return service.modify(vo);
//	}



}