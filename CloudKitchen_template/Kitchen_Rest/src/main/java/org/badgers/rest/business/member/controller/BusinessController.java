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
	
	//마페지
		@GetMapping(value = "/{bizId}/mypage", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
		public ResponseEntity<List<BizMemberVOExtend>>  selectById(@PathVariable("bizId") String biz_id) {
			List<BizMemberVOExtend> list = service.selectById();
				

			return new ResponseEntity<List<BizMemberVOExtend>>(list, HttpStatus.OK);
		}
	
	
	
	
	
}
