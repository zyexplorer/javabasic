package com.zhuyin.basic_algorithms;

import java.util.Scanner;

/**
 * @author Administrator
 *	问题：输入两个数，求它们的最大公约数和最小公倍数
 *	分析：
 *	求最大公约数：
 *	1）先确定两个数中较大的，
 *	2）如果较大数能够被较小数整除，那么最大公约数为较小数，返回
 *	3）如果较大数不能被较小数整除，那么将较小数作为新的较大数，将较大数除以较小数的余数作为新的较小数，重复步骤2）、3）
 *
 *	求最小公倍数：最小公倍数=两数之积除以两数的最大公约数，所以写出求最大公约数的方法，即可求出最小公倍数
 *				
 */
public class _4_MaxCommonDivisorAndMinCommonMultiple {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		try {
			System.out.println("请输入第一个正整数：");
			int num1=in.nextInt();
			System.out.println("请输入第二个正整数：");
			int num2=in.nextInt();
			if (num1<1||num2<1) {
				System.out.println("输入的不是正整数！");
			}                                                                 
			System.out.println(num1+"和"+num2+"的最大公约数是："+maxCommonDivisor2(num1,num2));     
			System.out.println(num1+"和"+num2+"的最小公倍数是："+minCommonMultiple(num1,num2));
		} catch (Exception e) {                 
			System.out.println("您输入有误，请核对后再输入！");
			e.printStackTrace();
		}finally {
			in.close();
		}
	}
	
	//用递归法求最大公约数
	private static int maxCommonDivisor1(int num1, int num2) {
		if(num1<num2){	//排序，保证num1为较大值
			int temp=num2;
			num2=num1;
			num1=temp;
		}
		if (num1%num2==0) {	//如果较大值能够整除较小值，那么最大公约数为较小值
			return num2;
		}else {
			return maxCommonDivisor1(num2, num1%num2);
		}
	}
	
	//用循环法求最大公约数
	private static int maxCommonDivisor2(int num1, int num2) {
		if(num1<num2){	//排序，保证num1为较大值
			int temp=num2;
			num2=num1;
			num1=temp;
		}
		while(num1%num2!=0){ //当较大数能够整除较小数时，则较小数即为最大公约数
			int temp=num1%num2;		//将余数赋给临时变量
			num1=num2;				//将较小数赋给较大数
			num2=temp;				//将临时变量赋给较小数
		}
		return num2;
	}
	
	//求最小公倍数	(最小公倍数等于两数之积除以两数的最大公约数)
	private static int minCommonMultiple(int num1, int num2) {
		return num1*num2/maxCommonDivisor1(num1, num2);
		
	}
}
