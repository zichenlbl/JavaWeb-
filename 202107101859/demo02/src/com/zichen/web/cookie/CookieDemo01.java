package com.zichen.web.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Cookie 快速入门
 * cookie中存中文数据
 * @author zc
 * @date 2021-07-17 18:57
 */
@WebServlet("/cookie01")
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // cookie中存中文 URL编码 Tomcat 8 版本以下不能直接存中文数据
        String name = URLEncoder.encode("张三", "utf-8");
        // 1.创建Cookie对象 可以创建多个Cookie 浏览器关闭后默认Cookie删除
        Cookie cookie = new Cookie("msg", "hello");
        Cookie cookie1 = new Cookie("code", name);
        // 设置Cookie保存在本地的时间 负数：默认 正数：存活时间(秒) 零：删除cookie参数
        cookie.setMaxAge(60);
        // 2.发送Cookie
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
