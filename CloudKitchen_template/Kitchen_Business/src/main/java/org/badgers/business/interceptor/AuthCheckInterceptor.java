package org.badgers.business.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;
@Log4j
public class AuthCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		log.info(session.getAttribute("bizId"));
		if(session.getAttribute("bizId")==null) {
			log.info("--------------------세션 체크 null-------------------------");
			response.sendRedirect("/business/main?msg=fail");
            return false;
			
		}
		
		return true;
	}


}