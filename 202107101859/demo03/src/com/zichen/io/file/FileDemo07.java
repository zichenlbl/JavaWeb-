package com.zichen.io.file;

import java.io.*;

/**
 * 缓冲字节流 BufferedInputStream 提高读写速度
 * 处理流：对节点流封装，或者对另外一个处理流封装 提高性能、灵活度
 * 1.使用缓冲流可以提高读写速度
 * 2.关闭高层流即可，高层流的关闭方法中实现了关闭底层流
 * 3.缓冲流速度快： 引入了输入输出两个缓冲区，大大减少了读写硬盘的次数
 * 4.刷新缓冲区（将缓冲区的最新数据写入文件中） 方法1.关闭高层输出流 方法2.bufferedOutputStream.flush(); 方法3：缓冲区满，自动刷新
 * @author zc
 * @date 2021-07-24 16:55
 */
public class FileDemo07 {

    public static void main(String[] args) {
        try (BufferedInputStream bufferedInputStream =
                     new BufferedInputStream(
                             new FileInputStream("f:/test.mp4")
                     );
             BufferedOutputStream bufferedOutputStream =
                     new BufferedOutputStream(
                             new FileOutputStream("f:/test1.mp4")
                     )
        ) {
            int len;
            while ((len = bufferedInputStream.read()) != -1) {
                // 写一个字节
                bufferedOutputStream.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
