package com.zichen.web.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ServletContext 获取MIME类型
 * @author zc
 * @date 2021-07-16 19:10
 */
@WebServlet("/demo12")
public class ServletDemo12 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.通过 request 对象获取
        ServletContext context = req.getServletContext();
        // 2.通过 HttpServlet 获取
        ServletContext context1 = this.getServletContext();
        // true
        System.out.println(context == context1);
        // 定义文件名称
        String filename = "test.jpg";
        // 获取MIME类型
        String mimeType = context.getMimeType(filename);
        // image/jpeg
        System.out.println(mimeType);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
