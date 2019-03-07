package com.badgers.business.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.badgers.business.service.BusinessService;

import lombok.Setter;

// 사업 현황 보기, 영업 상태 수정, 개인정보 수정, 요리 생방송 관리

public class BusinessController {
	
	@Setter(onMethod_ = { @Autowired } )
	private BusinessService service;
}
