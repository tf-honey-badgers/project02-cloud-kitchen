package org.badgers.rest.customer.member.service;

import java.util.List;

import org.badgers.rest.model.CustomerVO;
import org.badgers.rest.model.FavoriteVO;
import org.badgers.rest.model.OrderInfoVO;

public interface CustomerService {

	// 회원가입
	public boolean register(CustomerVO vo) throws Exception;

	// 로그인
	public String login(String id, String pw);
	
	//회원 정보
	public List<CustomerVO> selectById(String id);

	// 회원 정보 수정
	public int  modify(CustomerVO vo) throws Exception;

	//비번 수정 
	public int changePwd(String pw, String id)throws Exception;
	
	// 탈퇴 (상태코드 변경)
	public int  delete(CustomerVO vo) throws Exception;

	// 회원 리스트 
	public List<CustomerVO> readMember(String id) throws Exception;
	
	// 주문 내역 
	public List<OrderInfoVO> getOrderInfo(String custId);
	
	// 찜 내역 보기 
	public List<FavoriteVO> favorite(String custId);
	
	
	
}
