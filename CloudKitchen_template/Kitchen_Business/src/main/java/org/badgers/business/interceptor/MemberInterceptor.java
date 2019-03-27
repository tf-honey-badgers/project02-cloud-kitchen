package org.badgers.business.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("...................................interceptor...................");
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mv) throws Exception {
		
		Map map=mv.getModel();
		System.out.println(map.get("isSuccess"));
		
		if(map.containsKey("isSuccess")) {
			System.out.println("로그인 성공 했으니깐 세션 생성해주이소................................");
		}

		
		
		super.postHandle(request, response, handler, mv);
	}

}
