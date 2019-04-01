package org.badgers.rest.business.member.service;

import javax.inject.Inject;

import org.badgers.rest.business.member.persistence.BusinessMapper;
import org.badgers.rest.model.BizMemberVOExtend;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Inject
	private BusinessMapper mapper;
	
	// 회원정보
	@Override
	public BizMemberVOExtend selectById(String bizId) throws Exception {
		System.out.println("Kitchen_Rest 사업자 개인정보 읽기...............................");
		
		BizMemberVOExtend bizMember = mapper.selectById(bizId);
		
		return bizMember;
	}
	
	// 사업자 mypage 정보 수정 
	public int modify(BizMemberVOExtend mvo) throws Exception {
		System.out.println("수정수정수정수정=====================");

		return mapper.modify(mvo); 
	}
	
	// bizLiveStrm 입력
	public int inputBizLiveStrm(String bizId, String bizLiveStrm) throws Exception {
		System.out.println("Kitchen_Rest YouTube LiveStreaming 코드 입력...............................");
		
		return mapper.inputBizLiveStrm(bizId, bizLiveStrm);
	}
		
	// 로그인
	@Override
	public int login(String bizId, String pw) {
		System.out.println("로그인 ========================================");

		BizMemberVOExtend member = mapper.login(bizId, pw);
		return (member!=null) ? 1 : 0;
	}
	
	// ID 찾기 & 본인인증하기
	public String verify(BizMemberVOExtend mvo) throws Exception {
		String returnVal = "";
		
		try {
			returnVal = mapper.verify(mvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnVal;
	}
}
