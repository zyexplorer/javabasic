package com.zhuyin.basic_algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZY
 *	问题：打印所有水仙花数————水仙花数是指一个三位数，其各位数字立方和等于该数本身，例如：153=1^3+5^3+3^3
 */
public class _2_FindDaffodiNumber {
	public static void main(String[] args) {
		List<Integer>list=new ArrayList<Integer>();
		for(int i=100;i<1000;i++){
			int a=i/100;
			int b=(i-a*100)/10;
			int c=i%10;
			if (i==a*a*a+b*b*b+c*c*c) {
				list.add(i);
			}
		}
		System.out.print("水仙花数有：");
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
	}
}
