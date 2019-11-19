package com.zhuyin.designmode.observermode;

/**
 * <p>Title: LaoWang</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  13:04
 */
public class LaoWang implements Person {

    private static String name = "老王";

    public LaoWang() {
    }

    @Override
    public void getMessage(String msg) {
        System.out.println(name + "接收到消息：" + msg);
    }
}
