package org.badgers.business.member.service;

import org.badgers.business.model.BizMemberVo;
import org.springframework.http.ResponseEntity;

public interface BusinessService {

	public ResponseEntity<BizMemberVo> readBizMember(String bizId) throws Exception;
}
