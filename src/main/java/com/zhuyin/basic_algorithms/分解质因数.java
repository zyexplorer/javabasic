package com.zhuyin.basic_algorithms;

import java.util.Scanner;

/**
 * @author ZY
 *	将一个正整数分解质因数，如：输入90，打印出90=2*3*3*5
 *                                                
 *	程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
 *	1）如果这个质数恰好等于n，则说明分解质因数的过程已结束,打印出即可
 *	2）如果n>=k,但n能被k整除，则应打印出k的值，然后用n除以k的商作为新的正整数n，重复执行第一步
 *	3）如果n不能被k整除，则用k+1作为k的值，重复执行第一步
 */
public class 分解质因数 {
	public static void main(String[] args) {
		primeFactor();
	}

	private static void primeFactor() {
		Scanner in=new Scanner(System.in);
		System.out.println("请输入一个正整数：");
		try {
			int num=in.nextInt();
			if (num<2) {
				System.out.println("必须输入不小于2的正整数");	
			}else {
				int primeNumber=2;//定义最小的质数k
				System.out.print(num+"=");
				while (primeNumber<=num) {
					if (primeNumber==num) {	//如果这个数恰好等于最小质数k，则打印出
						System.out.print(primeNumber);
						break;
					}else if(num%primeNumber==0){	//如果这个数大于k，但能被k整除，则打印出k然后用n/k的值作为新的n，循环
						System.out.print(primeNumber+"*");
						num=num/primeNumber;
					}else {	//如果这个数不能被k整除，那么用k+1作为新的k，循环
						primeNumber++;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("必须输入正整数！");
		}finally {
			in.close();
		}
	}
}
