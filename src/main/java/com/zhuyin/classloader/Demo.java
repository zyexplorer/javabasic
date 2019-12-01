package com.zhuyin.classloader;

/**
 * <p>Title: Demo</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年12月01日  22:32
 */
public class Demo {

    public Demo() {
        System.out.println("IDEA Demo, parent ClassLoader:" + this.getClass().getClassLoader());
    }
}
