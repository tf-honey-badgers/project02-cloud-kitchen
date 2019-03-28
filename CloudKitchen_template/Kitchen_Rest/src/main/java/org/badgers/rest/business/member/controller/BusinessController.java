package org.badgers.rest.business.member.controller;

import org.badgers.rest.business.member.service.BusinessService;
import org.badgers.rest.model.BizMemberVOExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/business")
@Log4j
public class BusinessController {

	@Setter(onMethod_ = { @Autowired })
	private BusinessService service;
	
	// 개인정보 보기 
	@GetMapping(value = "/{biz_id}/mypage", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<BizMemberVOExtend>  selectById(@PathVariable("biz_id") String bizId) throws Exception {
		BizMemberVOExtend bizMember = service.selectById(bizId);

		return new ResponseEntity<BizMemberVOExtend>(bizMember, HttpStatus.OK);
	}
	
	// 개인정보 수정
	@PutMapping("/{biz_id}/mypage/modify")
	public ResponseEntity<Integer> modify(@PathVariable("biz_id")String bizId, @RequestBody BizMemberVOExtend mvo) {

		int returnVal = 0;

		try {
			returnVal = service.modify(mvo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Integer>(returnVal, HttpStatus.OK);
	}
	
	// 로그인
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody BizMemberVOExtend biz) throws Exception {
		 int returnVal = service.login(biz.getBizId(), biz.getPw());
		 
		 return (returnVal==1)?new ResponseEntity<>(HttpStatus.OK): new ResponseEntity<>(HttpStatus.UNAUTHORIZED);	
	}
	
	// ID 찾기 & 본인인증하기
	@PostMapping("/verify")
	public ResponseEntity<String> verify(@RequestBody BizMemberVOExtend mvo) throws Exception {
		 ResponseEntity<String> entity = null;
		 
		 log.info("Kitchen_Rest 사업자 ID 찾기...............................");

		 String returnVal = service.verify(mvo);
		 if(returnVal == null) { entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST); }
		 else { entity = new ResponseEntity<String>(returnVal, HttpStatus.OK); }
		 
		 return entity;
	}
}