package com.zhuyin.testnull;

import org.junit.Test;


public class TestNullTest {
    public static void main(String[] args) {
        NullTest myNullTest = null;
        System.out.println(myNullTest.getInt());

        System.out.println("==============================");

        String str = "a,b,c,,";
        String[] ary = str.split(",");
        //预期大于 3，结果是 3
        System.out.println(ary.length);
    }

    @Test
    public void test1() {
        int x = 271;
        int count = 0;
        while (x > 0) {
            count++;
            System.out.println("before:" + x + "——" + Integer.toBinaryString(x));
            System.out.println("before:" + (x - 1) + "——" + Integer.toBinaryString(x - 1));
            x = x & (x - 1);
            System.out.println("result:" + x + "——" + Integer.toBinaryString(x));
            System.out.println();
        }
        //5
        System.out.println(count);
    }

    @Test
    public void test2() {
        // int 为4字节 每个字节8位 最高一位符号位 1为正 0为负
        // 0000 0001 0000 0000
        System.out.println(Integer.toBinaryString(256));
        // 0000 0000 1111 1111
        System.out.println(Integer.toBinaryString(255));
        System.out.println(256 & 255);

        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Integer.toBinaryString(-128));
    }

}
