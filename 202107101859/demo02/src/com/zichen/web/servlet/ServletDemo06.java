package com.zichen.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * 获取请求消息体 请求通用方法
 * 测试 http://localhost:8080/demo06?username=zhangsan&hobby=game&hobby=study&password=中文
 * @author zc
 * @date 2021-07-15 23:07
 */
@WebServlet("/demo06")
public class ServletDemo06 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决请求参数中文乱码 设置流的编码
        req.setCharacterEncoding("utf-8");
        // 获取请求消息体 POST请求
        // 1.获取字符流
        BufferedReader reader = req.getReader();
        // 2.读取数据
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        // GET/POST通用方法 以后只用在GET/POST其中一个方法中写 另一个方法调用其中一个方法
        // 根据参数名称获取参数值
        String userName = req.getParameter("username");
        System.out.println("post\n" + userName);
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies
        ) {
            System.out.println(hobby);
        }
        System.out.println("----------------------------------");
        // 获取所有请求的参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            // 参数名称
            String element = parameterNames.nextElement();
            System.out.println(element);
            // 根据参数名称获取值
            String parameter = req.getParameter(element);
            System.out.println(parameter);
            System.out.println("----------------------------------");
        }
        // 获取所有参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String name : parameterMap.keySet()) {
            System.out.println(name);
            for (String value : parameterMap.get(name)) {
                System.out.println(value);
            }
            System.out.println("----------------------------------");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        System.out.println("get\n" + userName);
        // 通用方法只用在一个方法中写一遍 另一个方法调用它
        doPost(req, resp);
    }
}
