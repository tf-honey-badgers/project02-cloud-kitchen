package org.badgers.rest.customer.member.persistence;

import org.badgers.rest.model.CustomerVo;

public interface CustomerMapper {

	// 회원가입
	public void register(CustomerVo vo);

	// 로그인
	
	public CustomerVo login(String id, String pw);
	
	//회원 정보
	public CustomerVo selectById(String id);
	
	// 회원 정보 수정
	public int modify(CustomerVo vo);
	

	// 회원 삭제 (코드 수정)
	public int delete(CustomerVo vo);

}
