package org.badgers.customer.member.service;

import org.badgers.customer.model.CustomerVO;

public interface CustomerService {

	
	//회원 정보
	public CustomerVO readCustomer(String id)throws Exception;
	
	//로그인 
	public String login(CustomerVO vo) throws Exception;
}
