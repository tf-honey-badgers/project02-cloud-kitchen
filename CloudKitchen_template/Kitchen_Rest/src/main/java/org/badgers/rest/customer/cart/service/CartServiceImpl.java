package org.badgers.rest.customer.cart.service;

import java.util.List;

import org.badgers.rest.customer.cart.persistence.CartMapper;
import org.badgers.rest.model.CartDetailVo;
import org.badgers.rest.model.CartVoExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;

@Service
public class CartServiceImpl implements CartService {
	
	@Setter(onMethod_ = @Autowired)
	private CartMapper mapper;

	// C : 장바구니 추가 (한 번에 메뉴 하나 BUT 수량은 1개 이상 복수 추가 가능)
	@Transactional
	@Override
	public int addCart(CartVoExtend cart) {
		
		try {
			// cart 정보로 cart 테이블에 추가
			mapper.insertCart(cart);
			
			// cart에 포함된 List<CartDetailVo>로 cart_detail 테이블에 추가
			List<CartDetailVo> options = cart.getOptions();
			for(CartDetailVo option : options) {
				System.out.println(option);
				mapper.insertDetails(option);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 위 작업 2개 모두 성공적으로 수행되었을 경우 return 1; 하나라도 실패했을 경우 return 0
		return 1;
	}

	// R : 장바구니 읽기 (페이지 로딩할 때 & 결제로 넘어갈 때)
	@Override
	public List<CartVoExtend> readCart(String custId) {
//		return mapper.read(custId);
		return null;
	}

	// U : 장바구니 업데이트 (메뉴 수량과 별도 버튼으로 옵션 코드 & 수량 수정 가능 -> 수량을 0으로 만들 수는 없음)
	@Override
	public int updateCart(CartVoExtend cart) {
//		return mapper.update(cart);
		return 0;
	}

	// D : 장바구니에서 삭제 (하나씩 개별 삭제 OR 별도 버튼으로 전체 삭제)
	@Override
	public int deleteCart(String custId) {
//		return mapper.delete(custId);
		return 0;
	}
}