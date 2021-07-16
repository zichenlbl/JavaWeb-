package com.zichen.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 输出字符数据到浏览器
 * @author zc
 * @date 2021-07-16 14:04
 */
@WebServlet("/demo10")
public class ServletDemo10 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取流对象之前，设置流的默认编码；ISO-8859-1 设置为：GBK
        // 设置了content-type就不用设置该设置
        resp.setCharacterEncoding("utf-8");
        // 方法1 告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码解码
        resp.setHeader("content-type", "text/html;charset=utf-8");
        // 方法2 设置消息体数据的编码
        resp.setContentType("text/html;charset=utf-8");
        // 1.获取字符输出流
        PrintWriter writer = resp.getWriter();
        // 2.输出数据 不用刷新就可以把数据写入缓冲区
        writer.println("write");
        writer.write("<h1>hello</h1>");
        writer.println("中文");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
