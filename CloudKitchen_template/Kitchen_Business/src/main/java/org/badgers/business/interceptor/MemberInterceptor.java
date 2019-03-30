package org.badgers.business.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(".........................interceptor : preHandle...................");
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mv) throws Exception {
		System.out.println(".........................interceptor : postHandle...................");
		String result = response.getHeader("RESULT");
		//상태가 success 여서 header에 bizId가 담겨 있다면 세션 생성 
		if(result!=null) {
			HttpSession session = request.getSession(true);
			if(session != null) {
				session.setAttribute("bizId", result );	
			}else {
				System.out.println("session null 이다");
			}
		}
		
	}

}
