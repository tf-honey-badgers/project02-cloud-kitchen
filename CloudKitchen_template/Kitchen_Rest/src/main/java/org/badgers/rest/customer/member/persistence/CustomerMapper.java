package org.badgers.rest.customer.member.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.badgers.rest.model.CustomerVO;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderVO;

public interface CustomerMapper {

	// 회원가입
	public int register(CustomerVO vo) throws Exception;	

	// 로그인
	public CustomerVO login(@Param("id")String id, @Param("pw")String pw) throws Exception;

	//회원 정보
	public CustomerVO selectById(String id) throws Exception;	
	
	// 회원 정보 수정
	public int modify(CustomerVO vo);
	
	// 비번수정 
	public int changePwd(String id, String pw);
	
	// 회원 삭제 (코드 수정)
	public int delete(CustomerVO vo);
	
	//멤버 
	public List<CustomerVO> readMember(String id) throws Exception;
	
	//주문내역 상세
	public List<OrderInfoVO> getOrderInfo(String id);
	
	// ID 찾기
	public String verify(CustomerVO vo);

	//메일
	public void createAuthKey(String email, String AuthCode) throws Exception;

	//회원 인증 업데이트
	public int userAuth(String email, String AuthCode);

	//카카오
	public CustomerVO checkKakaoUser(@Param("id")String id);
	
	//주문내역
	public List<OrderVO> getOrder(String custId);
	}
