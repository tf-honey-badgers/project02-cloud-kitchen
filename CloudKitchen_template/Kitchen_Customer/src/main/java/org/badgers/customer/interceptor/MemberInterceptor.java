package org.badgers.customer.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(
				HttpServletRequest request,
				HttpServletResponse response,
				Object handler
			) throws Exception {
		System.out.println(".........................interceptor : preHandle...................");
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(
				HttpServletRequest request,
				HttpServletResponse response,
				Object handler,
				ModelAndView mv
			) throws Exception {
		System.out.println(".........................interceptor : postHandle...................");
		String uid = response.getHeader("id");
		String idx = response.getHeader("idx");
		String uname = response.getHeader("name");
		String uphone = response.getHeader("phone");
		String uaddr = response.getHeader("address");
		String uaddr2 = response.getHeader("addressDetail");
		System.out.println("인터셉터"+idx);
		//상태가 success 여서 header에 id가 담겨 있다면 세션 생성 
		HttpSession session = request.getSession(true);
		if(uid!=null) {
			if(session != null) {
					System.out.println("로그인 성공");
					session.setAttribute("uid", uid );	 // 사용자 id 
					session.setAttribute("idx", idx );	 // 사용자 idx 
					session.setAttribute("uname", uname );	 // 사용자  이름 
					session.setAttribute("phone", uphone );	 // 사용자 전화번호 
					session.setAttribute("addr1", uaddr );	 // 사용자 주소 1 (지도 주소) 
					session.setAttribute("addr2", uaddr2 );	 // 사용자 주소 2 (상세 주소)
			}
		}
		

		//map에 logout 이라는 키를 가지고 있으면 세션invalidate() 해주기
		if(mv!=null) {
			@SuppressWarnings("rawtypes")
			Map map = mv.getModel();
			if(map.containsKey("logout")) {
				session.invalidate();
			}
		}
	}	
}