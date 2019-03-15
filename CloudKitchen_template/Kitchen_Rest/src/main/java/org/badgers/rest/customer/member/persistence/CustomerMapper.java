package org.badgers.rest.customer.member.persistence;

import java.util.List;

import org.badgers.rest.model.CustomerVO;
import org.badgers.rest.model.OrderInfoVO;

public interface CustomerMapper {

	// 회원가입
	public void register(CustomerVO vo);

	// 로그인
	public CustomerVO login(String id, String pw);

	//회원 정보
	public List<CustomerVO> selectById(String id);	
	
	// 회원 정보 수정
	public int modify(CustomerVO vo);
	
	// 비번수정 
	public int changePwd(String id, String pw);
	
	// 회원 삭제 (코드 수정)
	public int delete(CustomerVO vo);
	
	//멤버 
	public List<CustomerVO> readMember(String id) throws Exception;
	
	//주문내역
	public List<OrderInfoVO> getOrderInfo(String custId);
	

}
