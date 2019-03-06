package com.badgers.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.badgers.customer.service.KitchenService;

import lombok.Setter;

// 키친 보여주기, 키친 검색하기, 키친 이동하기, 메뉴 선택하기, 요리 생방송 보기

@RestController
public class KitchenController {

	@Setter(onMethod_ = { @Autowired } )
	private KitchenService service;
}
