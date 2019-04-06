package com.zhuyin.stackimitate;

import java.util.LinkedList;

/**
 * 此类是用LinkedList类来模拟栈
 * @author ZY
 * @version v1.0
 */
public class MyStack {
	private LinkedList<Object>linkedList;
	public MyStack(){
		linkedList=new LinkedList<Object>();
	}
	
	public void add(Object object){
		linkedList.addFirst(object);
	}
	
	public Object get(){
		return linkedList.removeFirst();
	}
	
	public boolean isEmpty(){
		return linkedList.isEmpty();
	}
}
