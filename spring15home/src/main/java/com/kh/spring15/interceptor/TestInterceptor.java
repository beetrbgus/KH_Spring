package com.kh.spring15.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * 인터세버 
 * = 스프링의 처리과정에 간섭할 수 있는 객체
 * = AOP의 실제 구현체
 * = 상속을 통해서 구현
 * = DispatcherServlet의 작업에 간섭할 수 있다.
 * = DispatcherServlet 설정파일인 servlet-context.xml에 등록해야 한다.
 * */

public class TestInterceptor implements HandlerInterceptor{
	/*
	 * preHandle은 컨트롤러의 처리메소드가 실행되기 직전 시점을 간섭하는 메소드
	 * -return true일 경우 정상적 진행 가능
	 * -return false일 경우 차단
	 * 인터셉터는 Http전용이므로 HttpServletRequest , HttpServletResponse 제공
	 * -일반적으로 필터와 비슷한 용도로 사용(차단 혹은 허용)
	 * */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TestInterceptor의 postHandle 실행!");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
