package com.zhuyin.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZY
 * @version v1.0
 */
public class NumberTool {
    private NumberTool() {
    }

    /**
     * 此方法用来输入一个正整数
     *
     * @return 返回输入的正整数
     */
    public static int inputOneIntNumber() {
        // 方式1：while循环
        Scanner sc = null;
        int num = 0;
        System.out.println("请输入一个正整数：");
        boolean flag = false;
        while (!flag) {
            try {
                sc = new Scanner(System.in);
                num = sc.nextInt();
                if (num > 0) {
                    flag = true;
                } else {
                    System.out.println("0不是正整数，请重新输入一个正整数：");
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("您输入有误，请重新输入一个正整数：");
                flag = false;
            }
        }
        return num;

        // 方式2：do-while循环
		/*
		boolean flag = true;
		int num = 0;
		System.out.println("请输入一个正整数：");
		do {
			Scanner sc = new Scanner(System.in);
			// Scanner必须定义在循环内，每次进入循环都要new一个Scanner对象
			try {
				num = sc.nextInt();
				flag = true;
			} catch (Exception e) {
				System.out.println("您输入有误，请重新输入：");
				flag = false;
			}
		} while (!flag);
		*/
    }

    /**
     * 此方法用来输入n个正整数
     *
     * @param n 为需要输入的整数个数
     * @return 返回的集合里装着输入的所有数据
     */
    public static List<Integer> inputIntNumber(int n) {
        List<Integer> list = new ArrayList<Integer>();
        Scanner sc = null;
        boolean flag = false;
        int num = 0;
        for (int i = 1; i <= n; i++) {
            do {
                try {
                    System.out.println("请输入第" + i + "个正整数：");
                    sc = new Scanner(System.in);
                    num = sc.nextInt();
                    if (num > 0) {
                        list.add(num);
                        flag = true;
                    } else {
                        System.out.println("此次输入有误！(负数或0均不是正整数)");
                        flag = false;
                    }
                } catch (Exception e) {
                    System.out.println("此次输入有误！(非数字不是正整数)");
                    flag = false;
                }
            } while (!flag);

        }
        if (sc != null) {
            sc.close();
        }
        return list;
    }

    /**
     * 此方法用来判断一个int数据是否是完数。完数：一个数如果恰好等于他的因子之和，那么这个数就称为完数，例如6=1+2+3。
     *
     * @param num 为待判断的数据
     * @return 返回true表示该数是完数，false表示该数不是完数
     */
    public static boolean isPerfectNumber(int num) {
        // 方式1：和思想
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0)
                sum += i;
        }
        return sum == num;

        // 方式2：差思想
		/*
		int leftover = num;
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				leftover -= i;
			}
		}
		return leftover == 0;
		*/

    }

    /**
     * 此方法用来判断一个int数据是否是水仙花数。水仙花数：指一个三位数，其各位数字立方和等于该数本身，例如：153=1^3+5^3+3^3
     *
     * @param num 为待判断的数据
     * @return 返回1表示该数是水仙花数，返回-1表示该数不是水仙花数，返回0表示该数不在水仙花数判断范围
     */
    public static int isDaffodiNumber(int num) {
        // 定义一个变量用来存储该数的位数
        int n = 0;
        for (int i = 1; i <= num; i++) {
            int k = (int) Math.pow(10, i);
            // 一个正整数除以10^i后第一次小于或等于0，那么该数的位数就为i位。
            if ((num / k) <= 0) {
                n = i;
                // 拿到所需数值，跳出循环，无需再进行
                break;
            }
        }
        // System.out.println("该数的位数为："+n+"位");

        // 例如153，5687 找规律
        // 规律：一个整数某位上的数字等于该数整除该位的单位后对10取余，如:
        // 个位数字=该数/1%10
        // 十位数字=该数/10%10
        // 百位数字=该数/100%10
        // ...
        // int ge^3=(int) Math.pow(num/Math.pow(10, 0)%10, 3);
        // int shi^3=(int) Math.pow(num/Math.pow(10, 1)%10, 3);
        // int bai^3=(int) Math.pow(num/Math.pow(10, 2)%10, 3);
        // ...

        //定义求和变量用于存储累加的和
        int sum = 0;
        for (int i = 0; i < n; i++) {
            //将每个数位的3次幂累加到sum中
            // System.out.println(Math.pow((int)(num/Math.pow(10, i))%10, 3));
            // jdk5以后新特性，自动拆装箱    sum=sum+double,自动转成了int
            sum += Math.pow((int) (num / Math.pow(10, i)) % 10, 3);
        }
        //判断返回结果:如果该数不在水仙花数判断范围内则返回0；如果累加结果等于该数则返回1，否则返回-1
        if (num < 100 || num > 999) {
            return 0;
        } else if (sum == num) {
            return 1;
        } else {
            return -1;
        }
    }


    /**
     * 此方法用来对输入的正整数分解质因数
     *
     * @param num 为待分解质因数的正整数
     * @return 返回形如6=2*3的字符串
     */
    public static String primeFactor(int num) {
        if (num == 1) {
            return "该数不能分解质因数";
        } else {
            StringBuilder sb = new StringBuilder();
            //定义最小的质数k
            int minPrimeNumber = 2;
            sb.append(num).append("=");
            while (minPrimeNumber <= num) {
                //如果这个数恰好等于最小质数，则直接拼接该数
                if (minPrimeNumber == num) {
                    sb.append(num);
                    break;
                } else if (num % minPrimeNumber == 0) {
                    //如果这个输大于最小质数，但能被最小质数整除，则拼接最小质数后用n/k的值作为新的n，循环
                    sb.append(minPrimeNumber).append("*");
                    num /= minPrimeNumber;
                } else {    //如果这个数不能被k整除，那么用k+1作为新的k，循环
                    minPrimeNumber++;
                }
            }
            return sb.toString();
        }
    }

    /**
     * 此方法用来求两个正整数的最大公约数
     *
     * @param num1,num2为待求最大公约数的两个正整数
     * @return 返回两个正整数的最大公约数
     */
    public static int maxCommonDivisor(int num1, int num2) {
        //方式1：递归实现
        //1.先排序，保证num1>=num2
        if (num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        //2.如果较大值能够整除较小值，那么最大公约数就是最小值，返回最小值即可
        if (num1 % num2 == 0) {
            return num2;
        } else {    //3.如果较大值不能整除较小值，那么用较小值作为新的较大值，用较大值对较小值取余的结果作为新的较小值，重复以上过程
            return maxCommonDivisor(num2, num1 % num2);
        }

        //方式2：循环实现
        //1.先排序同方式1，保证num1>=num2
        //2.当较大值能够整除较小值时，较小值为最大公约数,否则将较小值作为新的较大值，将较大值对较小值取余的结果作为新的较小值，循环，条件是较大值不能整除较小值
		/*
		while (num1 % num2 != 0) {	
			int temp = num1 % num2;
			num1 = num2;
			num2 = temp;
		}
		return num2;
		*/
    }


    /**
     * 该方法用来求两个正整数的最小公倍数
     *
     * @param num1 num2 为待求最小公倍数的两个正整数
     * @return 返回两个数的最小公倍数
     */
    public static int minCommonMultiple(int num1, int num2) {
        //最小公倍数=两数之积/两数的最大公约数
        return num1 * num2 / maxCommonDivisor(num1, num2);
    }
}
