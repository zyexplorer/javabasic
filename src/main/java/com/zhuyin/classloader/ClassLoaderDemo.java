package com.zhuyin.classloader;

import sun.misc.Launcher;
import sun.misc.URLClassPath;

/**
 * <p>Title: ClassLoaderDemo</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年12月01日  21:14
 */
public class ClassLoaderDemo {

    private static int temp = 1;

    static {
        temp = 2;
        System.out.println("static block temp:" + temp);
    }

    public static void main(String[] args) {
        temp = 3;
        System.out.println("main temp:" + temp);

        System.out.println("当前的类加载器是：" + ClassLoaderDemo.class.getClassLoader());
        System.out.println("当前类的父类加载器是：" + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("当前类的父类的父类加载器是：" + ClassLoaderDemo.class.getClassLoader().getParent().getParent());

        URLClassPath bootstrapClassPath = Launcher.getBootstrapClassPath();
        System.out.println(bootstrapClassPath);
    }

}
