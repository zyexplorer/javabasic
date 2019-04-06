package com.zhuyin.basic_algorithms;

import java.util.Scanner;

/**
 * @author Administrator
 *	问题：输入一串字符，统计其中英文字母、空格、数字和其他字符的个数
 *	分析：从字符的ASCII码规律着手统计        
 */
public class 统计字符数量 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("请任意输入一串字符：");
		String str=in.nextLine();
		
		int charCount=0;
		int digitCount=0;
		int blankCount=0;
		int chineseCount=0;
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if (('A' <= ch && ch <= 'Z')||('a'<=ch&&ch<='z')) {
				charCount++;
			}
			if ('0'<=ch&&ch<='9') {
				digitCount++;
			}
			if (ch==' ') {
				blankCount++;
			}
			if (0x0391<=ch&&ch<=0xFFE5) {	//中文的Unicode编码在0x0391-0xFFE5之间   中文标点符号也算中文
				chineseCount++;
			}
		}
		System.out.println("英文:"+charCount+"个");
		System.out.println("数字:"+digitCount+"个");
		System.out.println("空格:"+blankCount+"个");
		System.out.println("中文:"+chineseCount+"个");
		in.close();
	}
}