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
		log.info("object handler 는 무슨 역할을 하는가????????");
		log.info(handler.toString());
		log.info("........................................................");
		//method(결제 방법)
		String method = (String)request.getParameter("method");
		
		HttpSession session = request.getSession();
		
		//PaymentVO를 제외한 모든 세팅이 끝난 OrderVOExtend를 가져온다
		OrderVOExtend order = (OrderVOExtend)session.getAttribute("order");
		
		//PaymentVO 생성
		OrderPaymentVO orderPaymentVO = new OrderPaymentVO();
		
		orderPaymentVO.setId(order.getId());
		orderPaymentVO.setAmount(order.getPayAmt());
		orderPaymentVO.setMethod(method);
		
		//OrderVOExtend에 PaymentVO를 set 해줌으로써 OrderVoExtend의 setting이 끝났다 
		order.setOrderPayment(orderPaymentVO);
		
		//모든 setting이 완료된 OrderVOExtend를 session에 저장
		session.setAttribute("order", order);
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	

}
