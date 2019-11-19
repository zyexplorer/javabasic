package com.zhuyin.designmode.singletonmode.test;

import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

import org.junit.Test;

import com.zhuyin.designmode.singletonmode.LazySingletonSafe;
import com.zhuyin.designmode.singletonmode.LazySingletonUnSafe;

/**
 * <p>Title: SingletonTest.java</p>
 * <p>Description: 进行并发测试</p>
 * <p>Company: </p>
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2018-4-30  下午04:02:54 
 * @version v1.0
 */
@SuppressWarnings("all")
public class SingletonTest {

	/*statics String[] path = new String[] { "" };
    statics Map<String, String> countMap = new Hashtable<String, String>();
    statics Map<String, String> countMap2 = new Hashtable<String, String>();
    statics Set<String> countSet = new HashSet<String>();
    statics List<String> list = new ArrayList<String>();  */
  
    @Test     
    public void testThreadJunit() throws Throwable {   
        //Runner数组，想当于并发多少个。 
        TestRunnable[] trs = new TestRunnable [1000];  
        for(int i=0;i<1000;i++){  
            //trs[i] = new MyThread1();  //测试线程不安全的懒汉式单例
        	//trs[i] = new MyThread2();	 //测试线程安全的懒汉式单例
        	//trs[i] = new MyThread3();	 //测试线程安全的懒汉式单例
        	trs[i] = new MyThread4();	 //测试线程安全的懒汉式单例
        }  

        // 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入 
        MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);  
        // 开发并发执行数组里定义的内容 
        mttr.runTestRunnables();  
    }  
  
    //懒汉式单例线程不安全测试
    private class MyThread1 extends TestRunnable {  
        @Override  
        public void runTest() throws Throwable {
            // 测试内容
        	System.out.println(LazySingletonUnSafe.getInstance());
        	//测试结果可以看到单例并不唯一
        	//com.zhuyin.designMode.singleton.LazySingletonUnSafe@111985e
        	//com.zhuyin.designMode.singleton.LazySingletonUnSafe@e7b3cf
        }  
    }
    
    private class MyThread2 extends TestRunnable {
		@Override
		public void runTest() throws Throwable {
			System.out.println(LazySingletonSafe.getInstance1());
		}
    }
    
    private class MyThread3 extends TestRunnable {
		@Override
		public void runTest() throws Throwable {
			System.out.println(LazySingletonSafe.getInstance2());
		}
    }
    
    private class MyThread4 extends TestRunnable {
		@Override
		public void runTest() throws Throwable {
			System.out.println(LazySingletonSafe.getInstance3());
		}
    }
    
}
