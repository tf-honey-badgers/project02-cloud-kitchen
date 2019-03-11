package org.badgers.rest.customer.cart.service;

import java.util.List;

import org.badgers.rest.model.CartDetailVo;
import org.badgers.rest.model.CartVoExtend;

public interface CartService {

// C : 메뉴 추가 (한 번에 메뉴 하나 BUT 수량은 1개 이상 복수 추가 가능)
	public int addCart(CartVoExtend cart);

	// 옵션 추가
	public int addOptions(List<CartDetailVo> options, String cartId);
	
// R : 메뉴 읽기 (페이지 로딩할 때 & 결제로 넘어갈 때)
	public List<CartVoExtend> readCart(String custId);
	
	// 옵션 읽기
	public List<CartDetailVo> readOptions(String cartId);
	
// U : 메뉴 업데이트 (수량을 0으로 만들 수는 없음)
	public int updateCart(CartVoExtend cart);
	
// D : 메뉴 삭제 (장바구니 항목 하나씩 삭제 (cartId 사용) OR 장바구니 항목 전체 삭제 (cartId 미사용))
	public int deleteCart(String custId, String cartId);

	// 옵션 삭제
	public int deleteOption(String cartId, String id);
	
	// 옵션 전체 삭제
	public int deleteAllOptions(String cartId);
}
