package com.zhuyin.designmode.adaptermode;

/**
 * <p>Title: VoltageAdapter</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  14:24
 */
public class VoltageAdapter {

    public void changeVoltage(int v) {
        System.out.println("原始电压：" + v + "V");
        System.out.println("降压后电压：" + (v - 200) + "V");
        System.out.println("开始充电...");
    }
}
