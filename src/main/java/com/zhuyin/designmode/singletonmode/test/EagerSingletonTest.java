package com.zhuyin.designmode.singletonmode.test;

import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

import org.junit.Test;

import com.zhuyin.designmode.singletonmode.EagerSingleton;

/**
 * <p>Title: EagerSingletonTest.java</p>
 * <p>Description: 饿汉式单例测试</p>
 * <p>Company: </p>
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2018-5-1  下午07:05:33 
 * @version v1.0
 */
public class EagerSingletonTest {

	@Test
	public void testThreadJunit() throws Throwable{
		TestRunnable[] trs = new TestRunnable[1000]; 
		for(int i=0;i<trs.length;i++){
			trs[i] = new MyThread();
		}
		// 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入 
        MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);  
        // 开发并发执行数组里定义的内容 
        mttr.runTestRunnables();  
	}
	
	private class MyThread extends TestRunnable{

		@Override
		public void runTest() {
			//测试方法写这里
			System.out.println(EagerSingleton.getInstance());
		}
	}
}
