package com.zichen.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * Filter过滤器 快速入门
 * "/*": 访问所有资源之前，都会执行该过滤器
 * @author zc
 * @date 2021-07-18 15:18
 */
@WebFilter("/*")
public class FilterDemo01 implements Filter {
    /**
     * 在服务器启动后，会创建Filter对象，然后调用init方法。只执行一次 用于加载资源
     * @param  filterConfig filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("init...");
    }

    /**
     * 每一次请求被拦截资源时，会执行 执行多次
     * @param servletRequest servletRequest
     * @param servletResponse servletResponse
     * @param filterChain filterChain
     * @throws IOException IOException
     * @throws ServletException ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter...");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("doFilter1...");
    }

    /**
     * 在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次 用于释放资源
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
