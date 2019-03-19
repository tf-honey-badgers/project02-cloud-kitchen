package org.badgers.business.member.service;

import org.badgers.business.model.BizMemberVOExtend;

public interface BusinessService {

	// 회원 정보
	public BizMemberVOExtend readBizMember(String bizId)throws Exception;

	// 정보수정
	public void updateBizMember(BizMemberVOExtend mvo) throws Exception;

	// 로그인
	public String login(BizMemberVOExtend bizMember) throws Exception;
	
	public String findBizId(BizMemberVOExtend bizMember) throws Exception;
}
