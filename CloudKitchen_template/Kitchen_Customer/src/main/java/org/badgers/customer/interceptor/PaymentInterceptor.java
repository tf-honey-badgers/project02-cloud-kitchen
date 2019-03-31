package org.badgers.customer.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.badgers.customer.model.CartDetailVO;
import org.badgers.customer.model.CartVOExtend;
import org.badgers.customer.model.OrderDetailVOExtend;
import org.badgers.customer.model.OrderOptionVO;
import org.badgers.customer.model.OrderPaymentVO;
import org.badgers.customer.model.OrderVOExtend;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;

@Log4j
public class PaymentInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		
		OrderVOExtend order = (OrderVOExtend)modelAndView.getModel().get("order");
		List<OrderDetailVOExtend> orderDetailList = new ArrayList<>();
		
		List<CartVOExtend> cartList = (List)session.getAttribute("cart");
		
		order.setKitchenName(cartList.get(0).getKitchenName());
		
		String orderId = "tjtjtj"+System.currentTimeMillis();
		order.setId(orderId);

		int payAmt = 0;
		
		for(CartVOExtend cart:cartList) {
			//메뉴 총액 모두 더해서 결제 금액 계산
			payAmt += cart.getTotalAmt();
			
			OrderDetailVOExtend orderDetail = new OrderDetailVOExtend();
			String orderDetailId=orderId+cartList.indexOf(cart);
			
			orderDetail.setId(orderDetailId);
			orderDetail.setMenuId(cart.getMenuId()+"");
			orderDetail.setMenuName(cart.getMenuName());
			orderDetail.setMenuPrice(cart.getUnitPrice());
			orderDetail.setQuantity(cart.getQuantity());
			orderDetail.setBizId(cart.getBizId());
			orderDetail.setBizName(cart.getBizName());
			orderDetail.setOrderId(orderId);
			
			int optionPrice = 0;
			List<OrderOptionVO> optionVOList = new ArrayList<>();
			
			if(cart.getOptions()==null) {
				orderDetail.setTotalAmt(orderDetail.getMenuPrice());
				orderDetailList.add(orderDetail);
				
				continue;
			}
			
			for(CartDetailVO cartDetail:cart.getOptions()) {
				//옵션 총액 더함
				optionPrice += cartDetail.getMenuOptPrice();
				
				OrderOptionVO orderOptionVO = new OrderOptionVO();
				orderOptionVO.setOptId(cartDetail.getMenuOptId()+"");
				orderOptionVO.setOptName(cartDetail.getMenuOptName());
				orderOptionVO.setOptPrice(cartDetail.getMenuOptPrice());
				orderOptionVO.setOrderDetailId(orderDetailId);
				
				optionVOList.add(orderOptionVO);
			}
			
			orderDetail.setAddOptionPrice(optionPrice);
			orderDetail.setOrderOptions(optionVOList.toArray(new OrderOptionVO[optionVOList.size()]));
			
			orderDetail.setTotalAmt(orderDetail.getAddOptionPrice()+orderDetail.getMenuPrice());
			
			orderDetailList.add(orderDetail);
			
		}
		
		order.setPayAmt(payAmt);
		order.setOrderDetails(orderDetailList.toArray(new OrderDetailVOExtend[orderDetailList.size()]));
		
		
		
		log.info(":::::::::::::::::::::::::::::::::::ORDER:::::::::::::::::::::::::::::::::::::::::::::::::::::");
		log.info(order);
		log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		session.setAttribute("order", order);
		
		super.postHandle(request, response, handler, modelAndView);
	}

}
