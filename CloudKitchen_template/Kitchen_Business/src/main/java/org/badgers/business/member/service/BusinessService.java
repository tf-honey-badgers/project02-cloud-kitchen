package org.badgers.business.member.service;

import org.badgers.business.model.BizMemberVOExtend;

public interface BusinessService {

	// 회원 정보
	public BizMemberVOExtend readBizMember(String bizId)throws Exception;

	// 정보수정
	public int updateBizMember(BizMemberVOExtend mvo) throws Exception;

	// 로그인
	public int login(String bizId, String pw) throws Exception;
}
