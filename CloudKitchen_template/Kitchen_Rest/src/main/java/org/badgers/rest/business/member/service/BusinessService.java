package org.badgers.rest.business.member.service;

import org.badgers.rest.model.CustomerVO;

public interface BusinessService {
	
	//로그인 
	public String login(String bizId, String pw);
	
	
	// 정보수정 
	public int  modify(CustomerVO vo) throws Exception;
	
	
	// 사업자 탈퇴 
	
	

		

	

	
	
	
	
}
