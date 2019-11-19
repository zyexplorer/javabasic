package com.zhuyin.reflect.instance1;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 需求：要往ArrayList<Integer>中放入字符串该如何实现
 * 分析：泛型只是给编译器看的，真正运行字节码文件时是没有泛型的（用反编译工具可查看）
 *
 * @author ZY
 */
public class ArrayListDemo {

    public static void main(String[] args) throws Exception {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        Class<?> c = arrayList.getClass();
        Method method = c.getMethod("add", Object.class);
        method.invoke(arrayList, "张三");
        method.invoke(arrayList, "李四");
        method.invoke(arrayList, "王五");

        //for循环会报类型转换异常 Stirng不能转换成Integer
//		for (Integer integer : arrayList) {
//			System.out.println(integer);
//		}
        //直接使用ArrayList的toString方法将数组中的元素输出，有输出说明已经放进去了
        System.out.println("arrayList:" + arrayList);    //[1, 2, 3, 张三, 李四, 王五]
    }
}
