package org.badgers.business.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;
@Log4j
public class MemberInterceptor extends HandlerInterceptorAdapter{

//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		System.out.println(".........................interceptor : preHandle...................");
//		return super.preHandle(request, response, handler);
//	}

	@SuppressWarnings("rawtypes")
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mv) throws Exception {
		log.info("interceptor : postHandle...................");
		String result = response.getHeader("RESULT");
		
		//상태가 success 여서 header에 bizId가 담겨 있다면 세션 생성 
		HttpSession session = request.getSession(true);
		if(result!=null) {
			if(session != null) {
					log.info("   로그인 성공");
					session.setAttribute("bizId", result );	
			}
		}
		//map에 logout 이라는 키를 가지고 있으면 세션invalidate() 해주기
		if(mv!=null) {
			Map map = mv.getModel();
			if(map.get("msg").equals("logout")) {
				session.invalidate();;
			}
		}
		
		
	}
	
	
	
}
