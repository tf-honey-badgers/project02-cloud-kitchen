package org.badgers.rest.customer.member.persistence;

import org.badgers.rest.model.CustomerVo;

public interface CustomerMapper {
	
	// 회원가입 
	public void insertCustomer(CustomerVo vo)throws Exception;

	//회원 정보 수정 
	public int update(CustomerVo vo); 
}
