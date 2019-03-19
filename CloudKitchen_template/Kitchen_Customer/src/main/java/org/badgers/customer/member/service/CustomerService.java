package org.badgers.customer.member.service;

import org.badgers.customer.model.CustomerVO;

public interface CustomerService {

	
	//회원 정보
	public CustomerVO readCustomerMember(String id)throws Exception;
}
