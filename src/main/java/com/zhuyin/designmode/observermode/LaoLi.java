package com.zhuyin.designmode.observermode;

/**
 * <p>Title: LaoLi</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  13:05
 */
public class LaoLi implements Person {

    private static String name = "老李";

    public LaoLi() {
    }

    @Override
    public void getMessage(String msg) {
        System.out.println(name + "接收到消息：" + msg);
    }
}
