package com.zhuyin.designmode.adaptermode;

/**
 * <p>Title: Phone</p>
 * <p>Description: 手机类</p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  14:20
 */
public class Phone {

    public static final int V = 220;

    private VoltageAdapter adapter;

    public Phone() {

    }

    public void charge() {
        adapter.changeVoltage(V);
    }

    public void setAdapter(VoltageAdapter adapter) {
        this.adapter = adapter;
    }

}
