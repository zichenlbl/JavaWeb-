package com.zichen.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Request 对象获取请求行数据
 * @author zc
 * @date 2021-07-15 15:52
 */
@WebServlet("/demo04")
public class ServletDemo04 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  获取请求方式
        String method = req.getMethod();
        // 获取虚拟目录
        String contextPath = req.getContextPath();
        // 获取Servlet路径
        String servletPath = req.getServletPath();
        // 获取get方式请求参数
        String queryString = req.getQueryString();
        // 获取请求URI
        String requestUri = req.getRequestURI();
        // 获取请求URL
        StringBuffer reqRequestUrl = req.getRequestURL();
        // 获取协议及版本
        String protocol = req.getProtocol();
        // 获取客户机的ip地址
        String remoteAddr= req.getRemoteAddr();

        System.out.println(method + "\n" + contextPath + "\n" + servletPath + "\n" + queryString + "\n" +
                requestUri + "\n" + reqRequestUrl + "\n" + protocol + "\n" + remoteAddr);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
