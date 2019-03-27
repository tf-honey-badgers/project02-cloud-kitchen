package org.badgers.rest.customer.cart.service;

import java.util.List;

import org.badgers.rest.customer.cart.persistence.CartMapper;
import org.badgers.rest.model.CartDetailVO;
import org.badgers.rest.model.CartVOExtend;
import org.mortbay.log.Log;
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
		// 이미 카트 테이블에 있는 주문인지 확인한다 (이미 있다면 수량만 늘린다)
		List<CartVOExtend> readCart = readCart(cart.getCustId());
		// 새로들어온 주문이 이미 있는 주문 수량만 바꿀 것인지를 나타내는 플래그 변수
		boolean flag = false;
		
		Log.info("********************* CHECKING WHETHER THERE'S ALREADY A RECORD IN THE CART TABLE WITH THE EXACT SAME MENU AND OPTIONS *********************");
		System.out.println(readCart);
		if(readCart != null) {
			for(int i = 0; i < readCart.size(); i++) {
				System.out.println("OUTER ITERATION IS : " + i);
				CartVOExtend fromCart = readCart.get(i);
				if(cart.getKitchenName().equals(fromCart.getKitchenName())
						&& cart.getBizId().equals(fromCart.getBizId())
						&& cart.getMenuId() == fromCart.getMenuId()) {
					if(cart.getOptions() != null && fromCart.getOptions() != null) {
						List<CartDetailVO> cartOptions = cart.getOptions();
						List<CartDetailVO> fromOptions = fromCart.getOptions();
						if(cartOptions.size() == fromOptions.size()) {
							for(int j = 0; j < cartOptions.size(); j++) {
								System.out.println("INNER ITERATION IS : " + j);
								CartDetailVO cartOptDetail = cartOptions.get(j);
								CartDetailVO fromOptDetail = fromOptions.get(j);
								if(cartOptDetail.getMenuId() == fromOptDetail.getMenuId()
										&& cartOptDetail.getMenuOptId() == fromOptDetail.getMenuOptId()
										&& cartOptDetail.getMenuOptPrice() == fromOptDetail.getMenuOptPrice()
										&& cartOptDetail.getMenuOptName().equals(fromOptDetail.getMenuOptName())) {
									System.out.println(cartOptDetail.getMenuId());
									System.out.println(fromOptDetail.getMenuId());
									System.out.println(cartOptDetail.getMenuOptId());
									System.out.println(fromOptDetail.getMenuOptId());
									System.out.println(cartOptDetail.getMenuOptPrice());
									System.out.println(fromOptDetail.getMenuOptPrice());
									System.out.println(cartOptDetail.getMenuOptName());
									System.out.println(fromOptDetail.getMenuOptName());
									Log.info("********************* THERE IS ALREADY A RECORD IN THE CART TABLE WITH THE EXACT SAME OPTION *********************");
									flag = true;
								} else {
									flag = false;
									break;
								}
							}							
						}
					} else {
						Log.info("********************* THERE IS ALREADY A RECORD IN THE CART TABLE WITH THE EXACT SAME MENU (NO OPTIONS) *********************");
						flag = true;
					}
				}
				if(flag) {
					cart.setId(fromCart.getId());
					cart.setQuantity(cart.getQuantity() + fromCart.getQuantity());
					cart.setTotalAmt(cart.getTotalAmt() + fromCart.getTotalAmt());
					int updateResult = updateCart(cart);
					System.out.println("THE RESULT OF UPDATING THE CART SHOULD BE ONE(1) : " + updateResult);
					return updateResult;
				}
			}
		}
		
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