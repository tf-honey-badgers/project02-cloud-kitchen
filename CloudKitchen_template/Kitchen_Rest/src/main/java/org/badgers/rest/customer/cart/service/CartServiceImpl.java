package org.badgers.rest.customer.cart.service;

import java.util.List;

import org.badgers.rest.customer.cart.persistence.CartMapper;
import org.badgers.rest.model.CartDetailVO;
import org.badgers.rest.model.CartVOExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;

@Service
public class CartServiceImpl implements CartService {
	
	@Setter(onMethod_ = @Autowired)
	private CartMapper mapper;

	// 메뉴 추가 (한 번에 메뉴 하나 BUT 수량은 1개 이상 복수 추가 가능)
	@Transactional
	@Override
	public int addCart(CartVOExtend cart) throws Exception { // controller에서 예외처리
		int addedCart = 0;
		int addedOptions = 0;
		
		// cart 정보로 cart 테이블에 추가
		addedCart = mapper.insertCart(cart);
		
		// cart에 포함된 List<CartDetailVo>로 cart_detail 테이블에 추가
		for(CartDetailVO option : cart.getOptions()) {
			addedOptions += mapper.insertOption(option);
		}
		
		return addedCart + addedOptions; // cart 테이블에 추가한 행 개수 + cart_detail 테이블에 추가한 행 개수 반환
	}

	// 메뉴 읽기 (페이지 로딩할 때 & 결제로 넘어갈 때)
	@Override
	public List<CartVOExtend> readCart(String custId) throws Exception {
		List<CartVOExtend> results = null;
		
		results = mapper.readCart(custId);
		
		return results;
	}

	// 메뉴 업데이트 (수량을 0으로 만들 수는 없음) -> 옵션은 업데이트 없다
	@Override
	public int updateCart(CartVOExtend cart) throws Exception {
		return mapper.updateCart(cart); // cart 테이블에 수정된 행 개수 반환
	}
	
	// 메뉴 삭제 (장바구니 항목 하나씩 삭제 (cartId 사용) OR 장바구니 항목 전체 삭제 (cartId 미사용))
	@Transactional
	@Override
	public int deleteCart(String custId, String cartId) throws Exception {
		int returnVal = 0;
		
		if(cartId != null) { // cartId != null이면 지정된 cartId를 가진 특정 장바구니 항목 하나만 삭제
			returnVal += mapper.deleteCart(cartId);
		} else { // cartId == null이면 장바구니 항목 전체 삭제
			returnVal += mapper.deleteAllCart(custId);
		}
		
		return returnVal; // cart_detail 테이블에서 삭제된 행 개수 + cart 테이블에서 삭제된 행 개수 반환
	}
}