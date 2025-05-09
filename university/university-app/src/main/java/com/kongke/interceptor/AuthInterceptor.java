package com.kongke.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * auth 拦截器
 *
 * @author kongke
 * @date 2025/04/06
 */
//@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//         Skip if the handler is not a method handler
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // Get token from header
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return false;
        }
        // Verify token here
        try {
            // Add your token verification logic here
            // For example: verify JWT token, check against database, etc.
            validateToken(token);
            return true;
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }

    private void validateToken(String token) {
        if (StringUtils.isEmpty(token) || !token.equals("Pass")) {
            throw new RuntimeException("Token is empty");
        }

    }
}

