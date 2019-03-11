package org.badgers.rest.customer.cart.persistence;

import java.util.List;

import org.badgers.rest.model.CartDetailVo;
import org.badgers.rest.model.CartVoExtend;

public interface CartMapper {

	// CartServiceImpl의 addCart & addOptions에서 사용
	public int getCartIdx() throws Exception;
	public int insertCart(CartVoExtend cart) throws Exception;
	public int getDetIdx() throws Exception;
	public int insertDetails(CartDetailVo option) throws Exception;
	
	// CartServiceImpl의 readCart & readOptions에서 사용
	public List<CartVoExtend> readCart(String custId) throws Exception;
	public List<CartDetailVo> readOptions(String cartId) throws Exception;
	
	// CartServiceImpl의 updateCart & updateOptions에서 사용
	public int updateCart(CartVoExtend cart) throws Exception;
	public int updateOptions(CartDetailVo option) throws Exception;
	
}
