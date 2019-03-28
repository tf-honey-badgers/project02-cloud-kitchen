package org.badgers.rest.customer.cart.persistence;

import java.util.List;

import org.badgers.rest.model.CartDetailVO;
import org.badgers.rest.model.CartVOExtend;

public interface CartMapper {
	
	// CartServiceImpl의 addCart & addOptions에서 사용
	public int insertCart(CartVOExtend cart) throws Exception;
	public int insertOption(CartDetailVO option) throws Exception;
	public int getCartId() throws Exception;
	
	// CartServiceImpl의 readCart & readOptions에서 사용
	public List<CartVOExtend> readCart(String custId) throws Exception;
	public List<CartVOExtend> readSelectedCart(int[] selectedCartId) throws Exception;
	public List<CartDetailVO> readOptions(int cartId) throws Exception;
	
	// CartServiceImpl의 updateCart에서 사용
	public int updateCart(CartVOExtend cart) throws Exception;
	
	// CartServiceImpl의 deleteCart & deleteOptions에서 사용
	public int deleteCart(String cartId) throws Exception;
	public int deleteAllCart(String custId) throws Exception;

}