package com.zhuyin.basic_algorithms;

import java.util.Scanner;

/**
 * @author ZY
 *	从键盘录入一个不大于8位的正整数，先将它倒序，然后每位数字加5除以10得到的余数作为该位的新数字，
 *  最后将最高位和最低位互换，输出加密后的数字
 *	例如输入123456，输出应该为：654321——>109876——>609871
 *		  12——>21——>76——>67
 */

public class Encryption {
	public static void main(String[] args) {
		System.out.println("请输入一个不大于8位的正整数：");
		Scanner sc=new Scanner(System.in);
		int num = 0;
		try {
			num = sc.nextInt();
		} catch (Exception e) {
			System.out.println("输入的数据不符合要求！");
		}
		encryp(num);	//将加密代码抽取成方法，只需要传入一个满足条件的数，就能输出加密后的数
		sc.close();
	}

	/**
	 * @param num
	 * 加密功能：先将数据倒序，然后每位数字加5除以10得到的余数作为该位的新数字，最后将最高位和最低位互换，输出加密后的数字
	 */
	public static void encryp(int num) {
		
		int n=0;
		if (num<10) {
			n=1;
		}else if (num<Math.pow(10, 8)) {
			for(int i=1;i<=8;i++){
				int temp=(int) Math.pow(10, i);
				if ((num/temp)>0&&(num/temp)<10) {
					n=i+1;
				}
			}
			System.out.println("您输入的是"+n+"位数："+num);
		}else {
			System.out.println("输入的数据过大，不合要求！");
			return;
		}
		int[] array = new int[n];
		/*
		int index=0;
		while(num>0){
			array[index]=num%10;	//每次对10取余得到整数的最后一位数字
			index++;
			num/=10;
		}
		*/
		for(int index=0;num>0;index++){
			array[index]=num%10;	//每次对10取余得到整数的最后一位数字
			num/=10;
		}
		//此时数组array中的索引顺序即为输入数据的倒序
		
		//然后每位数字加5除以10得到的余数作为该位的新数字
		for(int i=0;i<array.length;i++){
			array[i]=(array[i]+5)%10;
		}
		
		//最后将最高位和最低位互换
		int temp=array[0];
		array[0]=array[array.length-1];
		array[array.length-1]=temp;
		
		System.out.print("加密后的数据为：");
		for(int i:array){
			System.out.print(i);
		}
	}

}
