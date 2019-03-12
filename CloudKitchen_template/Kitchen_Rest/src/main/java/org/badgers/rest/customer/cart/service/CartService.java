package org.badgers.rest.customer.cart.service;

import java.util.List;

import org.badgers.rest.model.CartVoExtend;

public interface CartService {

	// C : 장바구니 추가 (한 번에 메뉴 하나 BUT 수량은 1개 이상 복수 추가 가능)
	public int addCart(CartVoExtend cart);

	// R : 장바구니 읽기 (페이지 로딩할 때 & 결제로 넘어갈 때)
	public List<CartVoExtend> readCart(String custId);
	
	// U : 장바구니 업데이트 (메뉴 수량과 별도 버튼으로 옵션 코드 & 수량 수정 가능 -> 수량을 0으로 만들 수는 없음)
	public int updateCart(CartVoExtend cart);	
	
	// D : 장바구니에서 삭제 (하나씩 개별 삭제 OR 별도 버튼으로 전체 삭제)
	public int deleteCart(String custId);
}
