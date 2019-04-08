package org.badgers.customer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;

@Log4j
public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(
				HttpServletRequest request,
				HttpServletResponse response,
				Object handler
			) throws Exception {
		String url = "", custId = (String) request.getSession().getAttribute("uid");
		log.info("UID IS : " + custId);
		
		if(request.getQueryString() == null) {
			if(custId == null) {
				log.info("------------------------- 로그인 안 한 상태 -------------------------");
				url = request.getRequestURI().toString() + "?auth=false";
				log.info(url);
				response.sendRedirect(url);
				return false;
			} else {
				url = request.getRequestURI().toString() + "?auth=true&custId=" + custId;
				log.info(url);
				response.sendRedirect(url);
			}
		} else {
			if(!request.getQueryString().contains("custId")) {
				if(custId != null) {
					url = request.getRequestURI().toString() + "?auth=true&custId=" + custId;
					log.info(url);
					response.sendRedirect(url);
				}
			}
		}
		return true;
	}
}