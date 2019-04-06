package com.zhuyin.reflect;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectDemo2 {
	public static void main(String[] args) throws Exception {
		Properties prop=new Properties();
		InputStream inputStream = ReflectDemo2.class.getClassLoader().getResourceAsStream("properties.properties");
		prop.load(inputStream);
		
		String className = prop.getProperty("className");
		String methodName = prop.getProperty("methodName");
		
		Class<?> c = Class.forName(className);
		//Object obj = c.newInstance();
		
		Field[] declaredFields = c.getDeclaredFields();
		int i=0; 
		for (Field field : declaredFields) {
			System.out.println(++i+":"+field);
		}
		
		Method method = c.getDeclaredMethod(methodName);
		System.out.println(method);
		System.out.println(method.getName());
		
		
	}
}
