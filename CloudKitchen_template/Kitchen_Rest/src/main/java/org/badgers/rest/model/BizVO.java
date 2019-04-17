package org.badgers.rest.model;

import lombok.Data;

@Data
public class BizVO {
	private String bizId;// 사업자 아이디 
	private String info; // 가게 소개 
	private String name;  // 가게 상호명 
	private int likeCnt; //찜횟수 
	private int minAmt;  // 최소 주문 금액
	private String catId; // 가게  메뉴 카테고리
	private String kitchenId; // 키친 아이디 (키친 위치 종각점인지 어딘지) 
	private String bizLiveStrm; // 사업자 생방송 키값, 아이디용
	private int idx;
}
