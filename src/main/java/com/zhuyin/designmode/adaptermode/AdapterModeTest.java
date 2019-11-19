package com.zhuyin.designmode.adaptermode;

/**
 * <p>Title: AdapterModeTest</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  14:28
 */
public class AdapterModeTest {

    public static void main(String[] args) {

        Phone phone = new Phone();
        VoltageAdapter adapter = new VoltageAdapter();
        phone.setAdapter(adapter);
        phone.charge();

    }

}
