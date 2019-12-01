package com.zhuyin.classloader;

/**
 * <p>Title: MyClassLoaderTest</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年12月01日  22:14
 */
public class MyClassLoaderTest {

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader("ZY", "D:/temp/");
        try {
            Class<?> c = myClassLoader.findClass("com.zhuyin.classloader.Demo");
            System.out.println(c.getDeclaredFields().length);
            System.out.println(c.getDeclaredMethods().length);
            Object o = c.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
