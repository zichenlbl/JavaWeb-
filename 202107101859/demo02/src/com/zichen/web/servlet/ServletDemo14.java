package com.zichen.web.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 文件下载
 * @author zc
 * @date 2021-07-16 20:21
 */
@WebServlet("/demo14")
public class ServletDemo14 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求参数, 文件名
        String filename = req.getParameter("filename");
        // 2.使用字节输入流加载文件进内存
        // 2.1找到文件服务器路径
        ServletContext servletContext = req.getServletContext();
        String realPath = servletContext.getRealPath("/" + filename);
        // 2.2用字节流关联
        FileInputStream fileInputStream = new FileInputStream(realPath);
        // 3.设置response响应头
        // 3.1获取下载文件的MIME类型
        String mimeType = servletContext.getMimeType(filename);
        // 3.2设置响应体类型为mimeType类型 告诉浏览器响应体数据格式及编码规则
        resp.setContentType(mimeType);
        // 3.3设置响应头的打开方式 attachment:附件
        // 3.3.1解决下载的文件名中文乱码
        // 3.3.2获取浏览器版本信息
        String agent = req.getHeader("user-agent");
        // 3.3.3借助工具类编码文件名
        filename = getFileName(agent, filename);
        resp.setHeader("content-disposition", "attachment;filename=" + filename);
        // 4.将输入流中的数据写出到输出流中
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(buff)) != -1) {
            outputStream.write(buff, 0, len);
        }
        // getOutputStream输出流 response会自己响应结束关闭
        // 关闭输入流
        fileInputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * 根据浏览器版本更改中文文件名编码
     * @param agent 浏览器版本
     * @param filename 中文文件名
     * @return 编码后的中文文件名
     * @throws IOException IOException
     */
    private static String getFileName(String agent, String filename) throws IOException {
        String msie = "MSIE";
        String firefox = "Firefox";
        if (agent.contains(msie)) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains(firefox)) {
            // 火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes(StandardCharsets.UTF_8)) + "?=";

        } else {
            // 其他浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
