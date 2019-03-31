package org.badgers.customer.interceptor;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.badgers.customer.model.OrderPaymentVO;
import org.badgers.customer.model.OrderVOExtend;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;

@Log4j
public class PayReadyInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		log.info(request.getAttribute("method"));
		
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		OrderVOExtend order = (OrderVOExtend)session.getAttribute("Order");
		
		String method = (String)modelAndView.getModel().get("method");
		
		OrderPaymentVO orderPaymentVO = new OrderPaymentVO();
		
		orderPaymentVO.setId(order.getId());
		orderPaymentVO.setAmount(order.getPayAmt());
		orderPaymentVO.setMethod(method);
		
		order.setOrderPayment(orderPaymentVO);
		
		session.setAttribute("Order", order);
		
		log.info(":::::::::::::::::::::::::::::::::::ORDER:::::::::::::::::::::::::::::::::::::::::::::::::::::");
		log.info(order);
		log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		
		super.postHandle(request, response, handler, modelAndView);
	}

}
