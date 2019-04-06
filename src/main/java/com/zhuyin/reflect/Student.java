package com.zhuyin.reflect;

public class Student {
	private String name;
	int age;
	public double income;
	
	Student() {
	}
	
	public Student(String name){
		this.name=name;
	}
	
	@SuppressWarnings("unused")
	private Student(String name,int age){
		this.name=name;
		this.age=age;
	}

	Student(String name, int age, double income) {
		this.name = name;
		this.age = age;
		this.income = income;
	}
	
	void show(){
		System.out.println("void show()");
	}
	
	@SuppressWarnings("unused")
	private void show1(){
		System.out.println("private void show1()");
	}
	
	public void show2(){
		System.out.println("public void show2()");
	}
	
	protected void show3(){
		System.out.println("protect void show3()");
	}	
	
	String rString(){
		System.out.println("private String rString()");
		return "string";
	}
	
	@SuppressWarnings("unused")
	private String rString1(){
		System.out.println("private String rString1()");
		return "string1";
	}
	
	public String rString2(){
		System.out.println("public String rString2()");
		return "string2";
	}
	
	protected String rString3(){
		System.out.println("protected String rString3()");
		return "string3";
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", income=" + income + "]";
	}	
	
	
	
	
}
