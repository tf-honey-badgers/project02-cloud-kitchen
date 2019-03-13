package org.badgers.rest.customer.member.persistence;

import org.badgers.rest.model.CustomerVO;

public interface CustomerMapper {

	// 회원가입
	public void register(CustomerVO vo);


	//회원 정보
	public CustomerVO selectById(String id);
	
	// 회원 정보 수정
	public int modify(CustomerVO vo);
	

	// 회원 삭제 (코드 수정)
	public int delete(CustomerVO vo);

}
