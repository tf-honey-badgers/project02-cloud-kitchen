package org.badgers.rest.customer.fcm.controller;

import org.badgers.rest.customer.fcm.service.CustFcmService;
import org.badgers.rest.model.FcmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@RequestMapping("/cust")
@Log4j
@Controller
public class CustFcmController {
	@Autowired private CustFcmService service;
	
	@PutMapping("/fcm")
	public ResponseEntity<Integer> updateFcmToken(@RequestBody FcmVO vo) {
		log.info(vo.getFcmToken()+",  "+vo.getId());
		int result =service.updateFcmToken(vo);
		log.info("token 값 업데이트 결과  :  "+result);
		return new ResponseEntity<>(result,HttpStatus.OK);
		}
	
	
	
	
	
}
