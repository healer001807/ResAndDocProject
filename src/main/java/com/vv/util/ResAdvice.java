package com.vv.util;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @program: ResAndDocProject
 * @description: 响应信息统一拦截
 * @author: kangwei
 * @create: 2023-05-24 15:05
 **/
// 此注解一定要加扫描
@RestControllerAdvice("com.vv.controller")
public class ResAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 如果body已经封装，则不需要封装
        if (body instanceof ResUtils) {
            return body;
        }
        return ResUtils.success(body);
    }
}
