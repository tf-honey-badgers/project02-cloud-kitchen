package org.badgers.customer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
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
		String url = "";
		HttpSession session = request.getSession();
		log.info("UID IS : " + session.getAttribute("uid"));

//		if(request.getQueryString() == null) {
//			if(session.getAttribute("uid") == null) {
//				log.info("------------------------- 로그인 안 한 상태 -------------------------");
//				url = request.getRequestURI().toString() + "?auth=false";
//				log.info(url);
//				response.sendRedirect(url);
//				log.info(1);
//				return false;
//			}
//			
//			url = request.getRequestURI().toString() + "?auth=true";
//			log.info(url);
//			log.info(2);
//			response.sendRedirect(url);			
//		}
		
		log.info(3);
		response.sendRedirect(url);
		return true;
	}

	@Override
	public void postHandle(
				HttpServletRequest request,
				HttpServletResponse response,
				Object handler,
				ModelAndView modelAndView
			) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		modelAndView.setViewName("bizMenu");
		System.out.println(modelAndView);
		log.info("why isn't this working?");
	}

}
