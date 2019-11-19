package com.zhuyin.basic_algorithms;

import com.zhuyin.common.User;

/**
 * @author Administrator
 * 	java中的参数传递都是值传递，基本数据类型（8类）为数值传递，引用类型为地址值传递
 *	A：基本数据类型值传递为数值传递
 *	B：引用类型值传递为地址值传递
 */
public class DeliveryTest {
	public static void main(String[] args) {
		int a = 10, b = 20;
		System.out.println("基本数据类型传递前：" + "a=" + a + ",b=" + b);
		//基本数据类型为数值传递
		DeliveryTest.change(a, b);
		System.out.println("基本数据类型传递后：" + "a=" + a + ",b=" + b);

		System.out.println("===========");
		
		int[] array = { 1, 2, 3, 4, 5 };
		System.out.print("引用类型传递前：");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
		//引用类型为地址值传递
		DeliveryTest.change(array);
		System.out.print("引用类型传递后：");
		for (int i : array) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println("==========");

		//字符串常量，非引用类型
		String s = "引用类型吗？";
		System.out.println("引用类型传递前：" + s);
		DeliveryTest.change(s);
		System.out.println("引用类型传递后：" + s);
		
		System.out.println("==========");
		
		User user = new User("zhangsan","123456");
		System.out.println("引用类型传递前：" + user);
		DeliveryTest.change(user);
		System.out.println("引用类型传递后：" + user);
	}

	private static void change(User user) {
		user.setUsername("lisi");
		user.setPassword("110220");
	}

	private static void change(String s) {
		s = "或许就是引用类型";
	}

	private static void change(int[] array) {
		for(int i=0;i<array.length;i++){
			if (array[i]%2==0) {
				array[i] *= 2;
			}
		}
	}

	private static void change(int a, int b) {
		//System.out.println("a="+a+",b="+b);
		int temp=a;
		a=b;
		b=temp;
		//System.out.println("a="+a+",b="+b);
	}
	
	
}
