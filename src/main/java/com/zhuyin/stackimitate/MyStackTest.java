package com.zhuyin.stackimitate;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack ms = new MyStack();
        ms.add("1");
        ms.add("2");
        ms.add("3");
        ms.add("4");

        while (!ms.isEmpty()) {
            System.out.println(ms.get());
            //	4	3	2	1	先进后出
        }
    }
}
