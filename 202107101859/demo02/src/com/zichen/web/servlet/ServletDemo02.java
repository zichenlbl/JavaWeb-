package com.zichen.web.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

/**
 * 继承 Servlet 的实现类 GenericServlet
 * GenericServlet 类 将 Servlet 类的 service 方法抽象，并将其它方法空实现
 * @author zc
 * @date 2021-07-11 23:48
 */
@WebServlet("/demo02")
public class ServletDemo02 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service...GenericServlet");
    }
}
