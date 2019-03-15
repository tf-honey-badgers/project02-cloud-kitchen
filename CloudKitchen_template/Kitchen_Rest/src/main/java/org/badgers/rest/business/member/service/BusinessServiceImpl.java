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

	@Override
	public int modify(BizMemberVOExtend bizMvo) throws Exception {
		
		return mapper.modify(bizMvo); // biz_member 테이블에 수정된 행 개수 반환
	}
	
	// 회원정보
	@Override
		public List<BizMemberVOExtend> selectById() {
			System.out.println("나와라=============");
			List<BizMemberVOExtend> list = mapper.selectById();

			return list;
		}
	
	
	
	

}
