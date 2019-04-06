package com.zhuyin.reflect;

public class Teacher {
	private String name;
	int age;
	public double income;
	
	Teacher() {
	}
	
	public Teacher(String name){
		this.name=name;
	}
	
	protected Teacher(int age){
		this.age=age;
	}
	
	@SuppressWarnings("unused")
	private Teacher(String name,int age){
		this.name=name;
		this.age=age;
	}

	Teacher(String name, int age, double income) {
		this.name = name;
		this.age = age;
		this.income = income;
	}
	
	void show(){
		System.out.println("void tshow()");
	}
	
	@SuppressWarnings("unused")
	private void show1(){
		System.out.println("private void tshow1()");
	}
	
	public void show2(){
		System.out.println("public void tshow2()");
	}
	
	protected void show3(){
		System.out.println("protect void tshow3()");
	}	
	
	String rString(){
		System.out.println("private String trString()");
		return "tstring";
	}
	
	@SuppressWarnings("unused")
	private String rString1(){
		System.out.println("private String trString1()");
		return "tstring1";
	}
	
	public String rString2(){
		System.out.println("public String trString2()");
		return "tstring2";
	}
	
	protected String rString3(){
		System.out.println("protected String rString3()");
		return "string3";
	}	
	
	protected String rString3(String s){
		System.out.println("protected String rString3()"+s);
		return "string3"+s;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + ", income=" + income + "]";
	}	
	
	
}
