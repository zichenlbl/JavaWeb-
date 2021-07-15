package com.zichen.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 获取请求头数据
 * @author zc
 * @date 2021-07-15 22:06
 */
@WebServlet("/demo05")
public class ServletDemo05 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求头数据
        // 1.获取所有请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        // 2.遍历
        while (headerNames.hasMoreElements()) {
            String element = headerNames.nextElement();
            // 根据名称获取请求头的值
            String header = req.getHeader(element);
            System.out.println(element + " - - " + header);
        }
        System.out.println("------------------------------");
        // 获取请求头User-Agent
        String header = req.getHeader("user-agent");
        // 判断user-agent的浏览器版本
        String chrome = "Chrome";
        String firefox = "Firefox";
        String edg = "Edg";
        // 请求头中是否包含chrome
        if (header.contains(chrome)) {
            System.out.println("谷歌浏览器");
        } else if (header.contains(firefox)) {
            System.out.println("火狐浏览器");
        }
        System.out.println("------------------------------");
        // 获取请求头referer 告诉服务器，我(当前请求)从哪里来?
        String referer = req.getHeader("referer");
        System.out.println(referer);
        // 防盗链
        String localhost = "localhost:8080";
        if (referer != null) {
            if (referer.contains(localhost)) {
                System.out.println("正常");
            } else {
                System.out.println("错误");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
