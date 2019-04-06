package com.zhuyin.basic_algorithms;

import com.zhuyin.tools.NumberTool;

/**
 * @author ZY
 * 题目：完数定义：一个数如果恰好等于他的因子之和，那么这个数就称为完数，例如6=1+2+3。
 * 需求：从键盘录入一个数，编程找出该数范围内的所有完数。
 * 
 * 分析：
 * 	A：从1到输入数据间遍历每一个数
 * 	B:拿每一个数从1除到这个数本身（不包括），如果除得禁就把除数（因子）存起来累加
 * 	C：如果累加的结果刚好等于这个数本身，那么这个数就是完数，输出即可
 */
public class 完数 {
	public static void main(String[] args) {
		//从键盘录入一个正整数，调用工具类实现
		int num = NumberTool.inputOneIntNumber();
		if(NumberTool.isPerfectNumber(num)){
			System.out.println("您输入的整数"+num+"本身是完数！");
		}else {
			System.out.println("您输入的整数"+num+"本身不是完数！");
		}
		System.out.println(num+"以内的完数如下：");
		
		//A：从1到输入数据间遍历每一个数
		for (int i = 1; i <= num; i++) {
			//定义一个变量用来存储所有因子的和
			int sum = 0;
			//B:拿每一个数从1除到这个数本身（不包括），
			for (int j = 1; j < i; j++){
				//B:如果除得尽就把除数（因子）存起来累加
				if (i % j == 0){
					sum += j;
				}
			}	
			//C：如果累加的结果刚好等于这个数本身，那么这个数就是完数，输出即可
			if (sum == i){
				System.out.print(i + " ");
			}
		}
	}
	
}
