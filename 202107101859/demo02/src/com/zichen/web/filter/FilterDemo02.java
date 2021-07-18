package com.zichen.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * Filter 拦截方式配置 浏览器直接请求资源 转发访问资源
 * 浏览器直接请求资源Servlet demo08，此过滤器不会被执行,
 * 请求资源Servlet demo07转发访问Servlet demo08资源，此过滤器会执行
 * @author zc
 * @date 2021-07-18 20:13
 */
@WebFilter(value = "/*", dispatcherTypes = {DispatcherType.FORWARD})
public class FilterDemo02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilterDemo02...");
    }

    @Override
    public void destroy() {

    }
}
