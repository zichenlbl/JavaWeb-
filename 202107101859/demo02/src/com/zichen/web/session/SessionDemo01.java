package com.zichen.web.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * Session 快速入门 存储数据
 * @author zc
 * @date 2021-07-17 21:03
 */
@WebServlet("/session01")
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用Session共享数据
        // 1.获取Session
        HttpSession session = req.getSession();
        // 2.存储数据
        session.setAttribute("username", "zhangsan");
        // 客户端关闭后，Session也相同
        Cookie jsessionid = new Cookie("JSESSIONID", session.getId());
        jsessionid.setMaxAge(60);
        resp.addCookie(jsessionid);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
