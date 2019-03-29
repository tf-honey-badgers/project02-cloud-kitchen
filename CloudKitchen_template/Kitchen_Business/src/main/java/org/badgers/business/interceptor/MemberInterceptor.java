package org.badgers.business.interceptor;

import javax.servlet.http.Cookie;
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
		
		System.out.println("=======================================");
		System.out.println("=======================================");
		
		String result = response.getHeader("RESULT");
		
		System.out.println("STATUS: " + result);
		HttpSession session = request.getSession(true);
		
		if(session != null) {
			System.out.println("xcvcvxcv");
			System.out.println(session);
//			session.setAttribute("bizId", result );	
			session.setAttribute("bizId", result );	
			System.out.println(session.getAttribute("bizId"));
			System.out.println("세션 생성 활인..........................ㄴ");
			
		}else {
			System.out.println("null 이다");
		}
		
//		Cookie ck = new Cookie("TESTCOOKIE", result);
		
//		response.addCookie(ck);
		
		
		
		System.out.println("=======================================");
		System.out.println("=======================================");
		
		
		
//		Map map=mv.getModel();
//		System.out.println(".........................interceptor : postHandle...................");
//		
//		if(map.get("status").equals("200")&&map.get("bizId")!=null) {
//			System.out.println(".....................로그인 성공 했으니깐 세션 생성해주이소................................");
//
//			HttpSession session=request.getSession();
//			
//			System.out.println(session);
//
//			System.out.println(".....................로그인 성공 했으니깐 세션 생성해주이소................................");
//			
////			HttpSession session=request.getSession();
//			session.setAttribute("bizId", map.get("bizId") );
//
//		}

		
		
	
	}

}
