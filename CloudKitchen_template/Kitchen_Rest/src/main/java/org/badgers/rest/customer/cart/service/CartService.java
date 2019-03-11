package org.badgers.rest.customer.cart.service;

import java.util.List;

import org.badgers.rest.model.CartDetailVo;
import org.badgers.rest.model.CartVoExtend;

public interface CartService {

	// C : 메뉴 추가 (한 번에 메뉴 하나 BUT 수량은 1개 이상 복수 추가 가능)
	public int addCart(CartVoExtend cart);

	// C : 옵션 추가
	public int addOptions(List<CartDetailVo> options, String cartId);
	
	// R : 메뉴 읽기 (페이지 로딩할 때 & 결제로 넘어갈 때)
	public List<CartVoExtend> readCart(String custId);
	
	// R : 옵션 읽기
	public List<CartDetailVo> readOptions(String cartId);
	
	// U : 메뉴 업데이트 (수량을 0으로 만들 수는 없음)
	public int updateCart(CartVoExtend cart);
	
	// U : 옵션 업데이트
	public int updateOptions(List<CartDetailVo> options);
	
	// D : 메뉴 삭제 (하나씩 개별 삭제 OR 별도 버튼으로 전체 삭제)
	public int deleteCart(List<String> custIdList);
	
	// D : 옵션 삭제
	public int deleteOptions(String cartId);
}
