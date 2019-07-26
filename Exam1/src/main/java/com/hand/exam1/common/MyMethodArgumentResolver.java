package com.hand.exam1.common;

import com.hand.exam1.vo.MyPage;
import com.hand.exam1.vo.Page;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class MyMethodArgumentResolver implements HandlerMethodArgumentResolver {
	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
		return null;
	}
//
//	public MyMethodArgumentResolver() {
//	}
//
//	@Override
//	public boolean supportsParameter(MethodParameter parameter) {
//		if (parameter.getParameterType().isAssignableFrom(Page.class) && parameter.hasParameterAnnotation(Page.class)) {
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//		Page currentUserAnnotation = parameter.getParameterAnnotation(MyPage.class);
//		Object object = webRequest.getAttribute(MyMethodArgumentResolver.value(), NativeWebRequest.SCOPE_SESSION);
//		if (object == null) {
//			String token = webRequest.getHeader("Authorization");
//			if (token == null) {
//				token = webRequest.getParameter("accessToken");
//			}
//			return "";
//		}
//		return object;
//	}
}
