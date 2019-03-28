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
		
	// 로그인
	@Override
	public String login(String bizId, String pw) {
		System.out.println("로그인 ========================================");

		String returnVal = "";
//		BizMemberVOExtend queryResult = null;
//		
//		try {
		BizMemberVOExtend member = mapper.login(bizId, pw);
		
		System.out.println(member);
		
//			if(queryResult.getPw().equals(pw)) {
//				returnVal = queryResult.getBizId(); // 입력한 비번 == DB 비번
//			} else {
//				returnVal = "BAD_PW"; // 입력한 비번 != DB 비번
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			returnVal = "NO_ID"; // DB에 입력한 ID 없음 표시
//		}
//
		return returnVal;
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
