package org.badgers.business.member.service;

import org.badgers.business.model.BizMemberVO;
import org.badgers.business.model.BizMemberVOExtend;
import org.springframework.http.ResponseEntity;

public interface BusinessService {

	public ResponseEntity<BizMemberVO> readBizMember(String bizId) throws Exception;
	
	public ResponseEntity<String> login(BizMemberVOExtend biz) throws Exception;
	
	public ResponseEntity<Integer> updateBizMember(String bizId, BizMemberVOExtend biz) throws Exception;
}
