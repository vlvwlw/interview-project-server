package com.example.interceptor;

import com.example.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * ClassName: LoginCheckInterceptor
 * Package: com.example.interceptor
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/25 23:07
 * @Version 1.0
 */
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    // 目标资源方法运行前运行，返回true：放行，false：不放行

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("text/json;charset=UTF-8"); // 这里指定字符编码为UTF-8

        // 判断请求接口是否为/login,是则放行
        System.out.println(request.getRequestURI());
        if(request.getRequestURI().equals("/login") || request.getRequestURI().equals("/register")){
            return true;
        }
        String token = request.getHeader("token");
        if(!StringUtils.hasLength(token)){
            String noLogin = "{\n" +
                    "    \"code\":0,\n" +
                    "    \"msg\":\"登录失效，请重新登录\",\n" +
                    "    \"data\":null\n" +
                    "}";
            response.getWriter().write(noLogin);
            return false;
        }

        // 验证token
        try {
            JwtUtils.parseJwt(token);
        } catch (Exception e) {
            String noLogin = "{\n" +
                    "    \"code\":0,\n" +
                    "    \"msg\":\"登录失效，请重新登录\",\n" +
                    "    \"data\":null\n" +
                    "}";
            response.getWriter().write(noLogin);
            return false;
        }

        return true;

    }
}
