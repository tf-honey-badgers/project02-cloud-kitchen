package org.badgers.rest.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BizMemberVOExtend {
	private String bizId; //사업자 아이디
	private String pw; // 비번
	private String name; // 이름
	private String regNo; // 사업자 등록번호
	private Timestamp joinDate; // 가입일
	private String account; // 계좌번호
	private BizVO biz; //biz 가게소개글, 상호명, 가게 카테고리 등등 가게 정보 
	private CommonCodeVO cc; // 상태코드 아이디, 이름, 설명
	private KitchenBranchVO kb; // 키친 아이디, 이름, 지역코드, 주소
	
	// biz 테이블 수정용으로 필요 (없으면 update 호출 시 에러)
	private String info;
	private int minAmt;
	private String bizLiveStrm;
}
