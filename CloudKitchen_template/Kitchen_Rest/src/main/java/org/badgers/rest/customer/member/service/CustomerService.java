package org.badgers.rest.customer.member.service;

import org.badgers.rest.model.CustomerVO;

public interface CustomerService {

	// 회원가입
	public boolean register(CustomerVO vo) throws Exception;

	// 로그인
	public boolean login(String id, String pw);
	
	//회원 정보 
	public CustomerVO selectById(String id);

	// 회원 정보 수정
	public int  modify(CustomerVO vo) throws Exception;

	// 탈퇴 (상태코드 변경)
	public int  delete(CustomerVO vo) throws Exception;

}
