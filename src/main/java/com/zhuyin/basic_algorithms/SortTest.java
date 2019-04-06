package com.zhuyin.basic_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortTest {
	public static void main(String[] args) {
		List<Double>list=new ArrayList<Double>();
		Scanner scanner=new Scanner(System.in);
		System.out.println("需要进行排序的数有多少个：");
		int totalCount=scanner.nextInt();
		for(int i=1;i<=totalCount;i++){
			System.out.println("请输入第"+i+"个数：");
			double num=scanner.nextDouble();
			list.add(num);
		}
		Collections.sort(list);
		System.out.println("这些数从小到大排列为：");
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i));
			if (i<list.size()-1) {
				System.out.print("<");
			}
		}
		scanner.close();
	}
}
