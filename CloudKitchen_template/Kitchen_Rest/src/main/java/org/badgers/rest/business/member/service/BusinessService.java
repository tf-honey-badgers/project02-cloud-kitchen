package org.badgers.rest.business.member.service;

import java.util.List;

import org.badgers.rest.model.BizMemberVOExtend;

public interface BusinessService {

	// 로그인
	public String login(String bizId, String pw) throws Exception;

	// 정보수정
	public int modify(BizMemberVOExtend bizMvo) throws Exception;

	// 회원 정보
	public List<BizMemberVOExtend> selectById() ;

}
