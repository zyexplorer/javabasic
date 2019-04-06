package com.zhuyin.reflect;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectDemo {

	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		//两种路径写法都可以
		//E:\JavaWeb\SpringMVC\SpringMVC-02-Annotation	直接拷贝盘符路径后需要全替换\为/，或者替换成\\
		//FileReader fileReader = new FileReader(new File("E:\\JavaWeb\\SSM\\Basic_Algorithms\\src\\com\\zhuyin\\reflect\\properties.properties"));
		FileReader fileReader = new FileReader(new File("E:\\Workspace\\JavaWeb\\SSM\\Basic_Algorithms\\config\\properties.properties"));
		prop.load(fileReader);
		fileReader.close();

		String className = prop.getProperty("className");
		String methodName = prop.getProperty("methodName");

		// 获得类的字节码对象 创建实例
		Class<?> c = Class.forName(className);
		Object obj = c.newInstance();
		
		//通过字节码对象获得该类的所有成员变量
		Field[] declaredFields = c.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(field);
		}
		
		System.out.println("-------------------------------------------------------------");
		
		//通过字节码对象获得该类中的指定成员变量
		Field field = c.getDeclaredField("name");
		System.out.println(field.getName());

		System.out.println("-------------------------------------------------------------");
		
		// 通过字节码对象获得该类中所有的构造方法
		Constructor<?>[] constructors = c.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}

		System.out.println("-------------------------------------------------------------");

		// 通过字节码对象获得该类中的指定构造方法
		Constructor<?> constructor = c.getDeclaredConstructor(int.class);
		constructor.setAccessible(true);
		Object newInstance = constructor.newInstance(30);
		System.out.println(newInstance);

		System.out.println("-------------------------------------------------------------");

		// 通过字节码对象获得该类中的指定构造方法
		Constructor<?> constructor1 = c.getDeclaredConstructor(String.class,int.class);
		constructor1.setAccessible(true);
		Object newInstance1 = constructor1.newInstance("张三",30);
		System.out.println(newInstance1);
		
		System.out.println("-------------------------------------------------------------");

		// 通过字节码对象获得该类中的指定构造方法
		Constructor<?> constructor2 = c.getDeclaredConstructor(String.class,int.class,double.class);
		constructor1.setAccessible(true);
		Object newInstance2 = constructor2.newInstance("张三",30,8888);
		System.out.println(newInstance2);

		System.out.println("-------------------------------------------------------------");

		// 通过字节码对象获得该类中所有的成员方法
		Method[] methods = c.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}

		System.out.println("-------------------------------------------------------------");

		// 通过字节码对象获得该类中的具体无参无返回值的方法
		Method method = c.getDeclaredMethod(methodName);
		// 设置访问权限
		method.setAccessible(true);
		method.invoke(obj);

		System.out.println("-------------------------------------------------------------");
		// 通过字节码对象获得该类中的具体带参有返回值的方法
		Method method2 = c.getDeclaredMethod(methodName, String.class);
		method2.setAccessible(true);
		Object object = method2.invoke(obj, "你好！");
		System.out.println(object);

	}

}
