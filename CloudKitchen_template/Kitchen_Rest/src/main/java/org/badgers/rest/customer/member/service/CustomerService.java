package org.badgers.rest.customer.member.service;

import org.badgers.rest.model.CustomerVo;

public interface CustomerService {


	// 회원가입 
	public void register(CustomerVo vo) throws Exception;
	
	// 로그인
	public CustomerVo login(CustomerVo vo)throws Exception;
	
	// 회원 정보 수정 
	public void modify(CustomerVo vo)throws Exception;
	
	// 탈퇴 -> 상태 변경 
	public void delete(CustomerVo vo)throws Exception;
	
	
	
	
	
}
