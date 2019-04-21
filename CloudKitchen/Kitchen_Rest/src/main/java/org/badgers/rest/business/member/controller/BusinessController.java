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

@RestController
@RequestMapping("/business")
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
		int returnVal = 0; // 몇 개 행을 수정했는지 표시하는 변수

		try {
			returnVal = service.modify(mvo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Integer>(returnVal, HttpStatus.OK);
	}
	
	// 개인정보 보기 
	@GetMapping(value = "/livestrm/{bizId}/{bizLiveStrm}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String>  inputBizLiveStrm(@PathVariable("bizId") String bizId, @PathVariable("bizLiveStrm") String bizLiveStrm) throws Exception {
		String returnVal = "";
		
		int result = service.inputBizLiveStrm(bizId, bizLiveStrm);
		if(result == 1) {
			returnVal = bizLiveStrm;
		}

		return new ResponseEntity<String>(returnVal, HttpStatus.OK);
	}
	
	// 로그인
	@PostMapping(value="/login" , produces = "application/json; charset=UTF-8")
	public ResponseEntity<String> login(@RequestBody BizMemberVOExtend biz) throws Exception {
		int returnVal = service.login(biz.getBizId(), biz.getPw());
		
		//로그인이 성공했는지 메세지 전송 , httpStatus로 성공 실패구분짓는것은 ..  header에 http프로토콜 상태를 알려주는 것이므로 에러유발... 좋은 코드가 아님 
		return (returnVal==1) ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>("fail", HttpStatus.OK);	
	}
	
	// ID 찾기 & 본인인증하기
	@PostMapping("/verify")
	public ResponseEntity<String> verify(@RequestBody BizMemberVOExtend mvo) throws Exception {
		ResponseEntity<String> entity = null;
		
		String returnVal = service.verify(mvo);
		if(returnVal == null) { entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST); }
		else { entity = new ResponseEntity<String>(returnVal, HttpStatus.OK); }
		
		return entity;
	}
}