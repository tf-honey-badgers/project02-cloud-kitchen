package org.badgers.rest.customer.order.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.badgers.rest.customer.order.persistence.CustOrderMapper;
import org.badgers.rest.model.OrderDetailVO;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderOptionVO;
import org.badgers.rest.model.OrderPaymentVO;
import org.badgers.rest.model.OrderVO;
import org.badgers.rest.model.ParamOrderVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustOrderServiceImpl implements CustOrderService {

	
	@Inject
	CustOrderMapper mapper;
	
	@Transactional()
	public void insertAAA(String val) {
		
		mapper.insert1(val);
		mapper.insert2(val);
		
	}
	
	@Override
	@Transactional()
	public int excuteOrder(ParamOrderVO vo) throws Exception {
		System.out.println("맨처음---------------------------------------------------------------------");
		
		//order_id 받아옴(idx)

		
		OrderVO orderVO=vo.getOrderVO();
		OrderDetailVO orderDetailVO =vo.getOrderDetailVO();
		OrderOptionVO orderOptionVO =vo.getOrderOptionVO();
		OrderPaymentVO orderPaymentVO =vo.getOrderPaymentVO();
		
		
		//기본 결제 정보 입력
		mapper.addPayment(orderPaymentVO);
		
		
		//order 기본 정보 입력
		mapper.initOrder(orderVO);
		System.out.println("1");
		
		//order_detail 기본 정보 입력
		mapper.initOrderDetail(orderDetailVO);
		System.out.println("2");
		
		//order_menu_option 기본 정보 입력(ex: 옵션 2개 추가 - 옵션은 0~ n개 사이) 
		mapper.initOrderMenuOption(orderOptionVO);
		System.out.println("3");
		//order_detail 에 add_option_price 컬럼을 Update
		
		return 0;
	}

	@Override
	public List<OrderInfoVO> getOrderInfo(String orderId) throws Exception {
		
		List<OrderInfoVO> list= mapper.getOrderInfo(orderId);
		
		return list;
	}
	
	public OrderVO getOrderWithOrderId(String orderId) throws Exception{
		OrderVO vo = mapper.test(orderId);
		
		vo.getId();
		return mapper.test(orderId);
		
	}

	@Override
	public List<OrderVO> getOrder(String orderId) {
		
		return mapper.getOrder(orderId);
	}


}
