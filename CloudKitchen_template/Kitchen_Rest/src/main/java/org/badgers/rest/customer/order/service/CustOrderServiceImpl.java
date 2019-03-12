package org.badgers.rest.customer.order.service;

import javax.inject.Inject;

import org.badgers.rest.customer.order.persistence.CustOrderMapper;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustOrderServiceImpl implements CustOrderService {

	
	@Inject
	CustOrderMapper mapper;
	
	@Override
	@Transactional()
	public int excuteOrder() throws Exception {
		System.out.println("맨처음---------------------------------------------------------------------");
		mapper.getOrderId();
		System.out.println(mapper.getOrderId());
		
		//order 기본 정보 입력
		mapper.initOrder();
		System.out.println("1");
		
		//order_detail 기본 정보 입력
		mapper.initOrderDetail();
		System.out.println("2");
		//order_menu_option 기본 정보 입력(ex: 옵션 2개 추가 - 옵션은 0~ n개 사이) 
		mapper.initOrderMenuOption();
		System.out.println("3");
		//order_detail 에 add_option_price 컬럼을 Update
		mapper.addOrderDetailOptionPrice();
		System.out.println("4");
		//order_detail 에 total_amt 컬럼을 Update
		mapper.addOrderDetailTotalAmount();
		System.out.println("5");
		//order 에 pay_amt 컬럼을 Update
		mapper.addOrderPayAmount();
		System.out.println("6");
		
		
		return 0;
	}

	@Override
	public OrderInfoVO getOrderInfo() throws Exception {
		
		OrderInfoVO vo= mapper.getOrderInfo();
		
		System.out.println(vo.getId());
		return vo;
	}
	
	public OrderVO test(String orderId) throws Exception{
		OrderVO vo = mapper.test(orderId);
		
		vo.getId();
		return mapper.test(orderId);
		
	}
	

}
