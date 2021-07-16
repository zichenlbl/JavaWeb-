package com.zichen.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static javax.swing.text.html.CSS.getAttribute;

/**
 * request域数据共享一次请求(转发)
 * @author zc
 * @date 2021-07-16 11:05
 */
@WebServlet("/demo08")
public class ServletDemo08 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo08访问");
        Object username = req.getAttribute("username");
        System.out.println(username);
        // 重定向也可以跳转到其他网址
        resp.sendRedirect("https://www.hujinya.com");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
