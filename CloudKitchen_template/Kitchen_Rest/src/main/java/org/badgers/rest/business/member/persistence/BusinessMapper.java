package org.badgers.rest.business.member.persistence;

import java.util.List;

import org.badgers.rest.model.BizMemberVOExtend;

public interface BusinessMapper {

	// 로그인
	public BizMemberVOExtend login(String bizId, String pw);

	// 회원 정보
	public List<BizMemberVOExtend> selectById();

	// 사업자 정보 수정
	public int modify(BizMemberVOExtend bizMvo);

}
