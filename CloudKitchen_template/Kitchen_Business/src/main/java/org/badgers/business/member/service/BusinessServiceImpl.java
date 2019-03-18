package org.badgers.business.member.service;

import java.util.List;

import org.badgers.business.model.BizMemberVO;
import org.badgers.business.model.BizMemberVOExtend;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BusinessServiceImpl implements BusinessService{

	@Override
	public BizMemberVOExtend readBizMember(String bizId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBizMember(BizMemberVOExtend mvo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int login(String bizId, String pw) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
