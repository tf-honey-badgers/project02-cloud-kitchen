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

	// 메뉴 추가 (한 번에 메뉴 하나 BUT 수량은 1개 이상 복수 추가 가능)
	@Transactional
	@Override
	public int addCart(CartVoExtend cart) {
		int returnVal = 0;
		
		try {
			// cart 테이블에서 idx 값 가져와서 id 값 생성하기
			int currentCartIdx = mapper.getCartIdx();
			String newCartId = "cart_" + currentCartIdx;
			cart.setId(newCartId);
			
			// cart 정보로 cart 테이블에 추가
			returnVal = mapper.insertCart(cart);
//			System.out.println("RETURNVAL IS : " + returnVal);
			
			returnVal = addOptions(cart.getOptions(), cart.getId());
//			System.out.println("RETURNVAL IS : " + returnVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnVal;
	}

	// 옵션 추가
	@Transactional
	@Override
	public int addOptions(List<CartDetailVo> options, String cartId) {
		int returnVal = 0;
		
		try {
			// cart에 포함된 List<CartDetailVo>로 cart_detail 테이블에 추가
			for(CartDetailVo option : options) {
				// cart_detail 테이블에서 idx 값 가져와서 id 값 생성하기
				int currentDetIdx = mapper.getDetIdx();
				String newDetId = "cart_detail_" + currentDetIdx;
				option.setId(newDetId);
				option.setCartId(cartId);
				returnVal = mapper.insertDetails(option);
//			System.out.println("RETURNVAL IS : " + returnVal);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnVal;
	}

	// 메뉴 읽기 (페이지 로딩할 때 & 결제로 넘어갈 때)
	@Transactional
	@Override
	public List<CartVoExtend> readCart(String custId) {
		List<CartVoExtend> results = null;
		
		try {
			results = mapper.readCart(custId);
			for(CartVoExtend menu : results) {
				menu.setOptions(readOptions(menu.getId()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return results;
	}

	// 옵션 읽기
	@Override
	public List<CartDetailVo> readOptions(String cartId) {
		List<CartDetailVo> result = null;
		
		try {
			result = mapper.readOptions(cartId);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	// 메뉴 업데이트 (수량을 0으로 만들 수는 없음)
	@Override
	public int updateCart(CartVoExtend cart) {
		int returnVal = 0;
		
		try {
			// cart 정보로 cart 테이블 수정
			returnVal = mapper.updateCart(cart);
//			System.out.println("RETURNVAL IS : " + returnVal);
			
			returnVal = updateOptions(cart.getOptions());
//			System.out.println("RETURNVAL IS : " + returnVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnVal;
	}

	// 옵션 업데이트
	@Override
	public int updateOptions(List<CartDetailVo> options) {
		int returnVal = 0;
		
		try {
			for(CartDetailVo option : options) {
				returnVal = mapper.updateOptions(option);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnVal;
	}

	// 메뉴 삭제 (하나씩 개별 삭제 OR 별도 버튼으로 전체 삭제)
	@Override
	public int deleteCart(List<String> custIdList) {
		return 0;
	}

	// 옵션 삭제
	@Override
	public int deleteOptions(String cartId) {
		return 0;
	}

}