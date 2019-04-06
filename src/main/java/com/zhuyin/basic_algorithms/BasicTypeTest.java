package com.zhuyin.basic_algorithms;

import org.junit.Test;

/**
 * @author ZY
 *	八大基本数据类型：
 *	1）整型：byte short int long
 *	2）浮点型：float double
 *	3）逻辑型：boolean
 *	4）字符型：char
 */
public class BasicTypeTest {
	@Test 
	public void testByte(){
		byte a=Byte.MAX_VALUE;
		byte b=Byte.MIN_VALUE;
		System.out.println(a);	//127 =2^7-1
		System.out.println(b);	//-128 =-2^7
	}
	
	@Test
	public void testShort(){
		short a=Short.MAX_VALUE;
		short b=Short.MIN_VALUE;
		System.out.println(a);	//32767	=2^15-1
		System.out.println(b);	//-32768 =-2^15
	}
	
	@Test
	public void testInt(){
		int a=Integer.MAX_VALUE;
		int b=Integer.MIN_VALUE;
		System.out.println(a);	//2147483647	=2^31-1
		System.out.println(b);	//-2147483648	=-2^31
	}
	
	@Test
	public void testLong(){
		long a=Long.MAX_VALUE;
		long b=Long.MIN_VALUE;
		System.out.println(a);	//9223372036854775807	=2^63-1
		System.out.println(b);	//-9223372036854775808	=-2^63
	}
	
	@Test
	public void testFloat(){
		float a=Float.MAX_VALUE;
		float b=Float.MIN_VALUE;
		System.out.println(a);	//3.4028235E38	=3.4028235*10^38
		System.out.println(b);	//1.4E-45	=1.4*10^(-45)
	}
	
	@Test
	public void testDouble(){
		double a=Double.MAX_VALUE;
		double b=Double.MIN_VALUE;
		System.out.println(a);	//1.7976931348623157E308	=1.7976931348623157*10^308
		System.out.println(b);	//4.9E-324	=4.9*10^(-324)
	}
	
	@Test
	public void testBoolean(){
		boolean a=Boolean.FALSE;
		boolean b=Boolean.TRUE;
		System.out.println(a);	//false
		System.out.println(b);	//true
	}
	
	@Test
	public void testChar(){
		char a=Character.MAX_VALUE;
		char b=Character.MIN_VALUE;
		System.out.println(a);
		System.out.println(b);
	}
}
