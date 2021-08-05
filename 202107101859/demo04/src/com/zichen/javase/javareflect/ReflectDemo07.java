package com.zichen.javase.javareflect;

import java.util.ResourceBundle;

/**
 * 通过资源绑定器获取配置文件的内容
 * java.util.* 包下提供了一个资源绑定器 便于获取属性配置文件中的内容
 * 前提是配置文件必须放在类路径下
 * @author zc
 * @date 2021-08-05 22:41
 */
public class ReflectDemo07 {

    public static void main(String[] args) {
        // test.properties 文件的后缀名不需要填 参数只用给文件名字
        ResourceBundle test = ResourceBundle.getBundle("test");
        String className = test.getString("className");
        System.out.println(className);
    }

}
