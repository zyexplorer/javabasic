package com.zhuyin.designmode.factorymode.abstractfactorymode;

/**
 * <p>Title: AK47</p>
 * <p>Description: 具体武器类</p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  16:16
 */
public class AK47 extends Weapon {

    @Override
    void shoot() {
        System.out.println("AK47开始疯狂射击...");
    }
}
