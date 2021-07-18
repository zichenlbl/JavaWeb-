package com.zichen.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * Filter 拦截方式配置 浏览器直接请求资源和转发访问资源都可访问
 * 注解配置执行顺序 按照类名的字符串比较规则比较，值小的先执行 AFilter 先于 BFilter 执行
 * @author zc
 * @date 2021-07-18 20:13
 */
@WebFilter(value = "/*", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class FilterDemo03 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter demo03...");
    }

    @Override
    public void destroy() {

    }
}
