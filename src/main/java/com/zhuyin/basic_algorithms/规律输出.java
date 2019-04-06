package com.zhuyin.basic_algorithms;

import java.util.Scanner;

/**
 * @author ZY
 *	问题：求s=a+aa+aaa+aaaa+a……a的值，其中a是一个数字。例如，2+22+222+2222+22222（此时共有5个数相加），几个数相加由键盘控制。
 *	程序分析：将这串数字看成是字符行列形式，用双层循环控制输出，内层控制行，外层控制列，用StringBuffer来拼接，每行拼接结束后再拼接"+"号，最后倒序输出
 *	计算结果：将每次拼接的数字全部加起来（注意所在位，用Math.pow(a,b)，即a^b来控制）得到最后结果
 */
public class 规律输出 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("请输入数字：（0-9）");
		int num=in.nextInt();
		System.out.println("请输入重复次数：（1-9）");
		int times=in.nextInt();
		int sum=0;
		System.out.print("sum=");
		
		/*
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<times;i++){
			for(int j=0;j<times-i;j++){
				sb.append(num);
				sum+=num*Math.pow(10, j);	//每拼接一次，就将该次拼接的值加到sum里面
			}
			if (i<times-1) {
				sb.append("+");
			}
		}
		System.out.print(sb.reverse()+"="+sum);	//此处需要倒序输出
		*/
		
		for(int i=0;i<times;i++){
			for(int j=0;j<=i;j++){
				System.out.print(num);
				sum+=num*Math.pow(10, j);	//每输出一次，就将该次输出的值加到sum里面
			}
			if (i<times-1) {
				System.out.print("+");
			}
		}
		System.out.print("="+sum);
		in.close();
	}
}
