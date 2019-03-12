package org.badgers.rest.customer.member.service;

import org.badgers.rest.model.CustomerVo;

public interface CustomerService {

	// 회원가입
	public boolean register(CustomerVo vo) throws Exception;

	// 로그인
	public boolean login(String id, String pw);
	
	//회원 정보 
	public CustomerVo selectById(String id);

	// 회원 정보 수정
	public int modify(CustomerVo vo) throws Exception;

	// 탈퇴 (상태코드 변경)
	public int delete(CustomerVo vo) throws Exception;

}
