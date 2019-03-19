package org.badgers.customer.member.service;

import org.badgers.customer.model.CustomerVO;

public interface CustomerService {

	//회원 정보
	public CustomerVO readCustomer(String id)throws Exception;
	
	//로그인 
	public String login(CustomerVO customer) throws Exception;
	
	// 정보수정
	public void updateCustomer(CustomerVO cvo) throws Exception;
}
