package com.badgers.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.badgers.business.service.MenuService;

import lombok.Setter;

// 메뉴 정보 관리, 리뷰/댓글 관리, 신고하기

@RestController
public class MenuController {
	
	@Setter(onMethod_ = { @Autowired } )
	private MenuService service;
}
