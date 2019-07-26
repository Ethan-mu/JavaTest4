package com.hand.exam1.common;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class RequestJsonHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver  {
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(RequestJson.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
								  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		RequestJson requestJson = parameter.getParameterAnnotation(RequestJson.class);
		String value = requestJson.value();
		Class clazz = parameter.getParameterType();
		String jsonData = webRequest.getParameter(value);
		if (jsonData == null) {
			return clazz.newInstance();
		}
		Object object = JSONObject.parseObject(jsonData, clazz);
		return object;
	}
}
