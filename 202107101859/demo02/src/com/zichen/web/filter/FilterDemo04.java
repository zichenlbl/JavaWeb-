package com.zichen.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.*;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词汇过滤 使用代理对象
 * @author zc
 * @date 2021-07-20 22:34
 */
@WebFilter("/testFilter04")
public class FilterDemo04 implements Filter {

    /**
     * 敏感词汇集合
      */
    private final List<String> list = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) {
        // 1.获取文件真实路径
        ServletContext servletContext = filterConfig.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
        try {
            // 2.读取文件
            BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));
            // 3.将文件的每一行数据添加到 list 中
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
            System.out.println("list: " + list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1.创建代理对象，增强 getParameter 方法
        ServletRequest proxyServletRequest = (ServletRequest) Proxy.newProxyInstance(
                servletRequest.getClass().getClassLoader(),
                servletRequest.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    // 增强 getParameter 方法
                    // 判断是否是 getParameter 方法
                    String getParameter = "getParameter";
                    if (method.getName().equals(getParameter)) {
                        // 增强返回值
                        // 获取返回值
                        String value = (String) method.invoke(servletRequest, args);
                        if (value != null) {
                            // 判断返回值中是否包含敏感词汇
                            for (String s : list) {
                                if (value.contains(s)) {
                                    value = value.replace(s, "***");
                                }
                            }
                        }
                        return value;
                    }
                    // 不是则 传递真实对象和 args 参数
                    return method.invoke(servletRequest, args);
                });
        // 2.放行
        filterChain.doFilter(proxyServletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
