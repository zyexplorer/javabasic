package com.zhuyin.basic_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.junit.Test;

import com.zhuyin.tools.NumberTool;

public class TestNumber {
    @Test    //测试水仙花数
    public void daffodiNumberTest() {
        int inputIntNumber = NumberTool.inputOneIntNumber();
        System.out.println(NumberTool.isDaffodiNumber(inputIntNumber));
        System.out.println(NumberTool.isDaffodiNumber(153));
        System.out.println(NumberTool.isDaffodiNumber(370));
        System.out.println(NumberTool.isDaffodiNumber(371));
        System.out.println(NumberTool.isDaffodiNumber(407));
        System.out.println(NumberTool.isDaffodiNumber(99));
        System.out.println(NumberTool.isDaffodiNumber(1000));

    }

    @Test    //测试分解质因数
    public void primeFactorTest() {
        int inputIntNumber = NumberTool.inputOneIntNumber();
        String primeFactorStr = NumberTool.primeFactor(inputIntNumber);
        System.out.println(primeFactorStr);
    }

    @Test    //测试求最大公约数和最小公倍数
    public void commonDivisoOrMultipleTest() {
        List<Integer> list = NumberTool.inputIntNumber(2);
        int inputIntNumber1 = list.get(0);
        int inputIntNumber2 = list.get(1);
        int maxCommonDivisor = NumberTool.maxCommonDivisor(inputIntNumber1, inputIntNumber2);
        int minCommonMultiple = NumberTool.minCommonMultiple(inputIntNumber1, inputIntNumber2);
        System.out.println(inputIntNumber1 + "与" + inputIntNumber2 + "的最大公约数是" + maxCommonDivisor + ",最小公倍数是" + minCommonMultiple);
    }

    @Test    //测试一个数是否是完数
    public void perfectNumberTest() {
        int num = NumberTool.inputOneIntNumber();
        boolean result = NumberTool.isPerfectNumber(num);
        if (result) {
            System.out.println(num + "是完数！");
        } else {
            System.out.println(num + "不是完数");
        }
    }

    @Test
    public void test1() {
        List<Integer> list = NumberTool.inputIntNumber(5);
        for (Integer integer : list) {
            System.out.println(integer + " ");
        }
    }

    @Test
    public void test2() {
        int number1 = NumberTool.inputOneIntNumber();
        int number2 = NumberTool.inputOneIntNumber();
        System.out.println(number1);
        System.out.println(number2);
    }

    @Test
    public void regexTest() {
        String regex2 = "^\\d{3}\\w{3}$";
        String a = "912ew1";
        System.out.println(a.matches(regex2));    //true

        String regex = "^[a-zA-Z]\\w{5,15}$";
        String str = "a12345abcdef";
        System.out.println(str.matches(regex));

        System.out.println(Pattern.matches("^[a-zA-Z]\\w{5,15}$", "a12345abcdef"));
    }

    @Test
    public void testArray() {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要装入数组中的数据个数：");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print(i + ".");
            int number = NumberTool.inputOneIntNumber();
            list.add(number);
        }

        Object[] array = list.toArray();
        Arrays.sort(array);

        System.out.println(Arrays.toString(array));
        scanner.close();
    }

    @Test
    public void test3() {
        System.out.println(16 >>> 2);
        System.out.println(6 << 3);
    }


    /**
     * 调试验证new的ArrayList初始容量为10，以后每次递增50%(调试即可看到)
     */
    @Test
    public void test4() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            arrayList.add(i);
        }
    }

}
