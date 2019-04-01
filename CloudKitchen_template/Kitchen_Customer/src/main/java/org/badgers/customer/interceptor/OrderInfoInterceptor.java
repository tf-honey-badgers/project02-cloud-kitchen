package org.badgers.customer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;

@Log4j
public class OrderInfoInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		/* 테스트용 */
		session.setAttribute("id", "TJ");
		session.setAttribute("phone", "01011112222");
		session.setAttribute("address", "고양시 우리집");
		/* --- */
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("cart", modelAndView.getModel().get("cartList"));
		log.info("==========================INTERCEPTOR========================================");
		log.info(modelAndView.getModel().get("cartList"));
	}
	
}