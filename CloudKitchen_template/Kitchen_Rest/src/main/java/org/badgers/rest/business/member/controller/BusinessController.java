package org.badgers.rest.business.member.controller;

import java.util.List;

import org.badgers.rest.business.member.service.BusinessService;
import org.badgers.rest.model.BizMemberVOExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//사업자 마이 페이지 정보 쭉쭉 
		@GetMapping(value = "/{biz_id}/mypage", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
		public ResponseEntity<List<BizMemberVOExtend>>  selectById(@PathVariable("biz_id") String bizId) throws Exception {
			List<BizMemberVOExtend> list = service.selectById(bizId);

			return new ResponseEntity<List<BizMemberVOExtend>>(list, HttpStatus.OK);
		}
		// 로그인
		@GetMapping(value = "/{biz_id}")
		public ResponseEntity<String> login(BizMemberVOExtend biz) throws Exception {
			 ResponseEntity<String> entity = null;
			 if(entity ==null || ((CharSequence) entity).length()==0) {
				 log.info("없다 없다====================");
			 }
			 try {
			      entity = new ResponseEntity<>(service.login(biz.getBizId(), biz.getPw()), HttpStatus.OK);
			      log.info("연결 ==================== ");
			    } catch (Exception e) {
			      e.printStackTrace();
			      entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			      log.info("에러 에러=========================== ");
			    }

			    return entity;	
			  }
		// 개인정보 수정
		@PutMapping("/{biz_id}/mypage/modify")
		public int modify(@PathVariable("biz_id")String bizId ,@RequestBody BizMemberVOExtend mvo) {

			int returnVal = 0;

			try {
				returnVal 	= service.modify(mvo);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return returnVal;
		}
	
	
	
}
