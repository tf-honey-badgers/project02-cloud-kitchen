package org.badgers.rest.business.member.service;

import java.util.List;

import javax.inject.Inject;

import org.badgers.rest.business.member.persistence.BusinessMapper;
import org.badgers.rest.customer.member.persistence.CustomerMapper;
import org.badgers.rest.model.BizMemberVOExtend;
import org.badgers.rest.model.CustomerVO;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Inject
	private BusinessMapper mapper;
	
	// 로그인
	@Override
	public String login(String bizId, String pw) {
		System.out.println("로그인 ========================================");

		String returnVal = "";
		BizMemberVOExtend queryResult = null;
		try {
			queryResult = mapper.login(bizId, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnVal;
	}
	
	// 사업자 mypage 정보 수정 
	public int modify(BizMemberVOExtend mvo) throws Exception {
		System.out.println("수정수정수정수정=====================");
		return mapper.modify(mvo); 
	}
	
	// 회원정보
	@Override
		public List<BizMemberVOExtend> selectById(String bizId) {
			System.out.println("사업자 정보 나와라=============");
			List<BizMemberVOExtend> list = mapper.selectById(bizId);

			return list;
		}
	
	
	
	

}
