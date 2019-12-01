package com.zhuyin.classloader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * <p>Title: MyClassLoader</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年12月01日  21:45
 */
public class MyClassLoader extends ClassLoader {

    /**
     * 类加载器的名称
     */
    private String name;

    /**
     * 加载的类的路径
     */
    private String path;

    public MyClassLoader(String name, String path) {
        // 让系统类加载器成为该类的父类加载器
        super();
        this.name = name;
        this.path = path;
    }

    public MyClassLoader(ClassLoader parent, String name, String path) {
        // 显式指定富加载器
        super(parent);
        this.name = name;
        this.path = path;
    }

    /**
     * 通过自定义加载器来加载我们自己定义的类
     * @param name class文件名
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 读取class文件转换成二进制字节数组
        byte[] data = readClassFileToByteArray(name);
        return super.defineClass(name, data, 0, data.length);
    }

    /**
     * 读取class文件转换成二进制字节数组
     * @param name 加载的类的名称
     *   com.zhuyin.classloader.ClassLoaderDemo ——> D:/temp/com/zhuyin/classloader/ClassLoaderDemo.class
     * @return
     */
    private byte[] readClassFileToByteArray(String name) {
        // 先将全限定名称的.转换成/
        name = name.replaceAll("\\.", "/");

        String filePath = this.path + name + ".class";

        // 通过文件输入流将class文件读取到流中写入到byte数组中
        File file = new File(filePath);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        FileInputStream fis = null;
        try {
            // 从class文件中获取输入流
            fis = new FileInputStream(file);
            int b;
            while ((b = fis.read()) != -1) {
                baos.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return baos.toByteArray();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
