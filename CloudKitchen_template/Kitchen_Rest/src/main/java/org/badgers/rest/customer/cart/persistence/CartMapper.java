package org.badgers.rest.customer.cart.persistence;

import org.badgers.rest.model.CartDetailVo;
import org.badgers.rest.model.CartVoExtend;

public interface CartMapper {

	// CartServiceImpl의 addCart에서 사용
	public void insertCart(CartVoExtend cart) throws Exception;
	public void insertDetails(CartDetailVo option) throws Exception;
	
	public 
	
}
