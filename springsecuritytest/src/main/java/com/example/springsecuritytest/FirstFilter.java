package com.example.springsecuritytest;

import javax.servlet.*;
import java.io.IOException;

public class FirstFilter implements Filter {//필터 1번 생성

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("FirstFilter 생성됨");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        System.out.println("=======First 필터 시작=======");
        chain.doFilter(request, response);
        System.out.println("=======First 필터 종료=======");

    }


    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("FirstFilter 사라짐");
    }
}
