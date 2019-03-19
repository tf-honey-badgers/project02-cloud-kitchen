package org.badgers.rest.business.member.persistence;

import org.badgers.rest.model.BizMemberVOExtend;

public interface BusinessMapper {

	// 회원 정보
	public BizMemberVOExtend selectById(String bizId);

	// 사업자 정보 수정
	public int modify(BizMemberVOExtend mvo);

	// 로그인
	public BizMemberVOExtend login(String bizId);
	
	// ID 찾기
	public String findId(String regNo, String account);
}
