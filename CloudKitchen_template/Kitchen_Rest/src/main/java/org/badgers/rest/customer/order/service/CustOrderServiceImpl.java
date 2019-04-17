package org.badgers.rest.customer.order.service;

import java.util.LinkedList;

import javax.inject.Inject;

import org.badgers.rest.customer.order.persistence.CustOrderMapper;
import org.badgers.rest.model.OrderDetailVOExtend;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderOptionVO;
import org.badgers.rest.model.OrderPaymentVO;
import org.badgers.rest.model.OrderVOExtend;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustOrderServiceImpl implements CustOrderService {

	
	@Inject
	CustOrderMapper mapper;
	
	@Override
	public LinkedList<OrderInfoVO> getOrderInfo(String orderId) throws Exception {
		
		LinkedList<OrderInfoVO> list = mapper.getOrderInfo(orderId);
		
		return list;
	}
	
	@Override
	@Transactional()
	public int excuteOrder(OrderVOExtend vo) throws Exception {

		//1. order INSERT
		mapper.initOrder(vo);
		
		//2. order_payment INSERT 
		//2-1. order_payment 뽑아옴
		OrderPaymentVO orderPaymentVO = vo.getOrderPayment();
		//2-2. insert 수행
		mapper.addPayment(orderPaymentVO);

		//3. order_detail INSERT
		//3-1. order_detail 배열 뽑아옴
		OrderDetailVOExtend[] orderDetails =vo.getOrderDetails();
		OrderDetailVOExtend orderDetailVOExtend = null;
		//3-2. 배열에 든 모든 객체의 insert 수행
		for(int i=0; i<orderDetails.length;i++) {
			orderDetailVOExtend = orderDetails[i];
			mapper.initOrderDetail(orderDetailVOExtend);
			
			//4. order_option INSERT
			//4-1. order_option 배열 뽑아옴
			OrderOptionVO[] orderOptions= orderDetailVOExtend.getOrderOptions();
			if(orderOptions==null)
				continue;
			OrderOptionVO orderOptionVO = null;
			//4-2. 배열에 든 모든 객체의 insert 수행
			for(int j=0; j<orderOptions.length; j++) {
				orderOptionVO = orderOptions[j];
				mapper.initOrderMenuOption(orderOptionVO);
			}
			
		}
		
		
		return 1;
	}
}
