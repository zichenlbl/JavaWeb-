package com.zichen.web.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * ServletContextListener 监听器的使用
 * 注解配置使用 @WebListener
 * web.xml配置使用 <listener><listener-class>com.zichen.web.listener.ListenerDemo01</listener-class></listener>
 * @author zc
 * @date 2021-07-20 23:54
 */
@WebListener
public class ListenerDemo01 implements ServletContextListener {

    /**
     * 监听 ServletContext 对象创建 ServletContext 对象服务器启动后自动创建
     * 在服务器启动后自动调用
     * @param sce sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // ServletContext 对象创建后一般用来加载资源文件 全局资源文件
        // 1.获取 ServletContext 对象
        ServletContext servletContext = sce.getServletContext();
        // 2.加载资源
        String contextConfig = servletContext.getInitParameter("contextConfig");
        // 3.获取真实路径
        String realPath = servletContext.getRealPath(contextConfig);
        // 4.加载进内存
        try {
            FileInputStream fileInputStream = new FileInputStream(realPath);
             // 加载到文件打印测试 java.io.FileInputStream@52dbb492
            System.out.println(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("ServletContext对象被创建了...");
    }

    /**
     * 在服务器关闭后， ServletContext 对象被销毁。当服务器正常关闭后该方法被调用
     * @param sce sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象被销毁了...");
    }

}
