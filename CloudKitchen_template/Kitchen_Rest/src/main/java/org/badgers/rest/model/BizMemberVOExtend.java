package org.badgers.rest.model;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class BizMemberVOExtend {
	private String bizId; //사업자 아이디 
	private String pw; // 비번 
	private String name; // 이름
	private String regNo; // 사업자 번호?
	private Timestamp joinDate; // 가입일
	private String account; // 계좌번호
	private List<BizVO> biz ; //biz 가게소개, 상호명, 가게 카테고리 정도 ? 
	private List<CommonCodeVO> cc ;
	private List<KitchenBranchVO> kb;
	private String info;
	private int minAmt;
	private String bizLiveStrm;
	
	

}
