package com.zhuyin.thread.extendsthread;

public class MyThread extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            synchronized (this.getClass()) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (ticket--) + "张票");
                } else {
                    flag = false;
                }
            }
        }
    }
}
