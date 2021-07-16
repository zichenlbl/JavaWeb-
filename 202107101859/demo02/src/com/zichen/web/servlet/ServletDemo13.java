package com.zichen.web.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ServletContext 共享数据 获取数据
 * ServletContext 获取文件的真实路径
 * @author zc
 * @date 2021-07-16 19:10
 */
@WebServlet("/demo13")
public class ServletDemo13 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.通过 request 对象获取
        ServletContext context = req.getServletContext();
        // 2.域对象 共享数据 整个应用
        Object username = context.getAttribute("username");
        System.out.println(username);
        // 获取文件的服务器路径
        String realPath = context.getRealPath("/WEB-INF/classes/testRealPath.txt");
        System.out.println(realPath);
        String realPath1 = context.getRealPath("/testRealPath1.txt");
        System.out.println(realPath1);
        String realPath2 = context.getRealPath("/WEB-INF/testRealPath2.txt");
        System.out.println(realPath2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
