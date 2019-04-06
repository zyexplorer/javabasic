package com.zhuyin.reflect.instance2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ZY
 *	需求：写一个方法来给任意类的任意成员变量赋值
 *	分析：任意类、任意成员变量想到反射
 *	方法：public void setObjectProperty(Object o, String propertyName, Object value){}
 */
public class SetProperty {

	public static void setObjectProperty(Object o, String propertyName,Object value) throws Exception {
		//通过对象获得该对象的字节码对象
		Class<? extends Object> c = o.getClass();
		
		//获得名为propertyName的成员变量
		Field field = c.getDeclaredField(propertyName);
		
		//取消访问检查(私有的也能访问)
		field.setAccessible(true);
		
		//为该变量赋值(反射设置)
		field.set(o, value);
	}
	
	public static void setMethodAccessible(Object o, String methodName) throws Exception {
		//通过对象获得该对象的字节码对象
		Class<? extends Object> c = o.getClass();
		Object obj = c.newInstance();
		System.out.println("2——>"+obj);
		
		//通过字节码对象获得所有方法
		Method[] methods = c.getDeclaredMethods();
		for (Method method : methods) {
			method.setAccessible(true);
			Object object = method.invoke(obj);
			System.out.println("3——>"+object);
		}
	}
	
	
}
