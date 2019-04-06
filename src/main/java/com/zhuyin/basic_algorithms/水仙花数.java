package com.zhuyin.basic_algorithms;

import java.util.Scanner;

/**
 * @author ZY
 *	问题：不死神兔————有一对兔子从出生后第3个月起，每个月都生一对兔子，小兔子长到第3个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 *	分析：兔子的规律为斐波那契数列1，1，2，3，5，8，13，21，34，55，89，……
 */
public class 水仙花数 {
	public static void main(String[] args) {
		System.out.println("请输入第几个月：");
		Scanner in=new Scanner(System.in);
		int month=in.nextInt();
		System.out.println("第"+month+"个月的兔子总数为:"+feibo(month));
		in.close();
	}
	
	//方法递归
	private static int feibo(int month) {
		if (month==1||month==2) {
			return 1;
		}else{
			return feibo(month-1)+feibo(month-2);
		}
	}
}
