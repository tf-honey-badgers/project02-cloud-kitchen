package org.badgers.rest.business.member.persistence;

import org.apache.ibatis.annotations.Param;
import org.badgers.rest.model.BizMemberVOExtend;

public interface BusinessMapper {

	// 회원 정보
	public BizMemberVOExtend selectById(String bizId);

	// 사업자 정보 수정
	public int modify(BizMemberVOExtend mvo);
	
	// bizLiveStrm 입력
	public int inputBizLiveStrm(String bizId, String bizLiveStrm);

	// 로그인
	public BizMemberVOExtend login(@Param("bizId")String bizId, @Param("pw")String pw);
	
	// ID 찾기
	public String verify(BizMemberVOExtend mvo);
}
