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
		List<CartVOExtend> readCart = readCart(cart.getCustId());
		// 새로들어온 메뉴가 Cart 테이블에 있는 메뉴와 동일한지 나타내는 플래그 변수
		boolean flag = false;
		
		System.out.println(01);
		if(!readCart.isEmpty()) { // custId를 가진 메뉴가 Cart 테이블에 있는가? (없다면 readCart는 empty List object이다)
			for(int i = 0; i < readCart.size(); i++) {
				CartVOExtend fromCart = readCart.get(i);
				if(cart.getKitchenName().equals(fromCart.getKitchenName())
						&& cart.getBizId().equals(fromCart.getBizId())
						&& cart.getMenuId() == fromCart.getMenuId()) { // 새 메뉴와 Cart에 있는 메뉴가 정보가 같은가?
					if(cart.getOptions() == null && fromCart.getOptions().isEmpty()) { // 새 메뉴와 Cart에 있는 메뉴에게 옵션 정보가 없는가?
						flag = true;
					} else if(cart.getOptions() != null && !fromCart.getOptions().isEmpty()) { // 새 메뉴와 Cart에 있는 메뉴 둘 다 옵션 정보가 있는가?
						List<CartDetailVO> cartOptions = cart.getOptions();
						List<CartDetailVO> fromOptions = fromCart.getOptions();
						if(cartOptions.size() == fromOptions.size()) { // 새로들어온 메뉴 옵션과 Cart 테이블에 있는 메뉴 옵션 개수가 같은가?
							for(int j = 0; j < cartOptions.size(); j++) {
								CartDetailVO cartOptDetail = cartOptions.get(j);
								CartDetailVO fromOptDetail = fromOptions.get(j);
								if(cartOptDetail.getMenuId() == fromOptDetail.getMenuId()
										&& cartOptDetail.getMenuOptId() == fromOptDetail.getMenuOptId()
										&& cartOptDetail.getMenuOptPrice() == fromOptDetail.getMenuOptPrice()
										&& cartOptDetail.getMenuOptName().equals(fromOptDetail.getMenuOptName())) { // 새로들어온 메뉴 옵션과 Cart 테이블에 있는 메뉴 옵션 정보가 같은가?
									flag = true;
								} else {
									flag = false;
									break; // 하나라도 옵션 정보가 같지 않다면 옵션 비교 for문을 끝낸다.
								}
							}
						}
					}
				}
				if(flag) { // 새로들어온 메뉴 정보와 Cart 테이블에 있는 메뉴 정보가 일치한다면 수량을 증가시키고 메서드를 끝낸다.
					cart.setId(fromCart.getId());
					cart.setQuantity(cart.getQuantity() + fromCart.getQuantity());
					cart.setTotalAmt(cart.getTotalAmt() + fromCart.getTotalAmt());
					return updateCart(cart);
				}
			}
		}

		// 새로들어온 메뉴 정보와 Cart 테이블에 있는 메뉴 정보가 다르다면 새로운 메뉴로 취급한다. (Cart 테이블에 새로운 튜플을 추가한다.)
		int addedCart = 0;
		int addedOptions = 0;
		
		// cart 정보로 cart 테이블에 추가
		addedCart = mapper.insertCart(cart);
		
		int id = mapper.getCartId();		
		// cart에 포함된 List<CartDetailVo>로 cart_detail 테이블에 추가
		if(cart.getOptions() != null) {
			for(CartDetailVO option : cart.getOptions()) {
				option.setCartId(id);
				addedOptions += mapper.insertOption(option);
			}
		}
		
		return addedCart + addedOptions; // cart 테이블에 추가한 행 개수 + cart_detail 테이블에 추가한 행 개수 반환
	}

	// 메뉴 읽기 (페이지 로딩할 때 & 결제로 넘어갈 때)
	@Override
	public List<CartVOExtend> readCart(String custId) throws Exception {
		List<CartVOExtend> returnVal = null;
		
		returnVal = mapper.readCart(custId);
		
		for(int i = 0; i < returnVal.size(); i++) {
			List<CartDetailVO> options = mapper.readOptions(returnVal.get(i).getId());
			returnVal.get(i).setOptions(options);
		}
		return returnVal;
	}
	
	// 선택된 메뉴 읽기(결제로 넘어갈 때)
	@Override
	public List<CartVOExtend> readSelectedCart(int[] selectedCartId) throws Exception {
		List<CartVOExtend> returnVal = null;
		
		returnVal = mapper.readSelectedCart(selectedCartId);
		
		for(int i = 0; i < returnVal.size(); i++) {
			List<CartDetailVO> options = mapper.readOptions(returnVal.get(i).getId());
			returnVal.get(i).setOptions(options);
		}
		return returnVal;
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
		
	// cartId != null이면 지정된 cartId를 가진 특정 장바구니 항목 하나만 삭제
		if(cartId != null) { returnVal += mapper.deleteCart(cartId); }
	// cartId == null이면 장바구니 항목 전체 삭제
		else { returnVal += mapper.deleteAllCart(custId); }
		
		return returnVal; // cart_detail 테이블에서 삭제된 행 개수 + cart 테이블에서 삭제된 행 개수 반환
	}

	@Override
	public int deleteAllCart(String custId) throws Exception {
		mapper.deleteAllCart(custId);	
		return 0;
	}
}