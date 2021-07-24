package com.zichen.io.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取文件或者文件夹的属性
 * @author zc
 * @date 2021-07-24 10:15
 */
public class FileDemo01 {

    public static void main(String[] args) {
        // 绝对路径 根路径
        // File file = new File("f:\\test.txt");
        // File file = new File("f:/test.txt");
        // 相对路径
        // File file = new File("test.txt");
        File file = new File("test");
        // 文件名
        System.out.println(file.getName());
        // 绝对路径
        System.out.println(file.getAbsolutePath());
        // 长度 字符
        System.out.println(file.length());
        // 是否存在
        System.out.println(file.exists());

        // 可读
        System.out.println(file.canRead());
        // 可写
        System.out.println(file.canWrite());
        // 可执行
        System.out.println(file.canExecute());

        // 是文件吗？
        System.out.println(file.isFile());
        // 是文件夹吗？ 是目录吗？
        System.out.println(file.isDirectory());

        // 显示文件夹下的文件名 文件类型 文件修改日期
        // 文件数组
        File[] files = file.listFiles();
        // 文件名数组
        String[] list = file.list();
        assert list != null;
        for (String s : list) {
            System.out.println(s);
        }
        assert files != null;
        System.out.println(files.length);
        for (File f : files) {
            System.out.printf(
                    "%-12s%-21s",
                    f.getName(),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(f.lastModified())));
            if (f.isDirectory()) {
                // 是文件夹，输出<DIR>
                System.out.println("<DIR>");
            } else {
                // 是文件，输出文件大小
                System.out.println(f.length());
            }

        }
    }

}
