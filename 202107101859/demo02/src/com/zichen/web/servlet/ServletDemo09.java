package com.zichen.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 重定向
 * @author zc
 * @date 2021-07-16 12:29
 */
@WebServlet("/demo09")
public class ServletDemo09 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 重定向两次请求 使用请求域传递参数获取不到 username=李四
        req.setAttribute("username", "李四");
        System.out.println("demo09访问");
        // 动态获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        // 重定向方法1 访问demo09会自动跳转到demo08
//        redirect(resp);
        // 重定向方法2
        resp.sendRedirect( contextPath+ "/demo08");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * 重定向方法1
     * @param resp 响应消息体
     */
    private void redirect(HttpServletResponse resp) {
        // 1.设置状态码为302
        resp.setStatus(302);
        // 2.设置响应头location
        resp.setHeader("location","/demo08");
    }
}
