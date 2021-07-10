package com.zichen.web.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * Servlet 快速入门
 * Servlet 的方法
 * @author zc
 * @date 2021-07-10 21:32
 */
public class ServletDemo01 implements Servlet{
    /**
     * 初始化方法
     * 在 Servlet 被创建时，执行。只会执行一次。
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 获取 ServletConfig 对象
     * ServletConfig：Servlet 的配置对象
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * 每一次 Servlet 被访问时，执行。执行多次。
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service...");
    }

    /**
     * 获取 Servlet 的一些信息，版本、作者等。
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器正常关闭时，执行。执行一次。
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
