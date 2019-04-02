package org.badgers.rest.business.member.service;

import org.badgers.rest.model.BizMemberVOExtend;

public interface BusinessService {

	// 회원 정보
	public BizMemberVOExtend selectById(String bizId)throws Exception;

	// 정보수정
	public int modify(BizMemberVOExtend mvo) throws Exception;
	
	// bizLiveStrm 입력
	public int inputBizLiveStrm(String bizId, String bizLiveStrm) throws Exception;

	// 로그인
	public int login(String bizId, String pw) throws Exception;

	// ID 찾기 & 본인인증하기
	public String verify(BizMemberVOExtend mvo) throws Exception;
}
