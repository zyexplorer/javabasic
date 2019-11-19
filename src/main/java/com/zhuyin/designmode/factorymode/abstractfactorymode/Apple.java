package com.zhuyin.designmode.factorymode.abstractfactorymode;

/**
 * <p>Title: Apple</p>
 * <p>Description: 具体食物类</p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  16:16
 */
public class Apple extends Food {

    @Override
    void taste() {
        System.out.println("苹果尝起来很香甜...");
    }
}
