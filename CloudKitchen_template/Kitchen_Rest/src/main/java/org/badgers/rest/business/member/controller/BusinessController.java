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
	public int modify(@PathVariable("biz_id")String bizId, @RequestBody BizMemberVOExtend mvo) {

		int returnVal = 0;

		try {
			returnVal 	= service.modify(mvo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnVal;
	}
	
	// 로그인
	@PostMapping(value = "/")
	public ResponseEntity<String> login(@RequestBody BizMemberVOExtend biz) throws Exception {
		 ResponseEntity<String> entity = null;
		 
		 System.out.println(biz.getBizId());

		 try {
			 int returnVal = service.login(biz.getBizId(), biz.getPw());
			 if(returnVal == 1) { // 정상처리, 아이디를 다시 돌려보낸다 -> 프런트 도메인에서 로그인 처리할 것
				 entity = new ResponseEntity<String>(biz.getBizId(), HttpStatus.OK);
			 } else if (returnVal == -1) { // 아이디는 맞지만 비번 틀림
				 entity = new ResponseEntity<String>("PW_BAD", HttpStatus.BAD_REQUEST);
			 } else if (returnVal == -2) { // 아이디가 존재하지 않는다
				 entity = new ResponseEntity<String>("NO_ID", HttpStatus.BAD_REQUEST);
			 }
			 log.info("연결 ==================== ");
		 } catch (Exception e) {
			 e.printStackTrace();
			 entity = new ResponseEntity<String>("SERVER_ERROR", HttpStatus.SERVICE_UNAVAILABLE);
			 log.info("에러 에러=========================== ");
		 }
		 
		 return entity;	
	}
}