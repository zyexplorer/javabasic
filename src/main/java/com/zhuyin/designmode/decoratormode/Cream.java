package com.zhuyin.designmode.decoratormode;

import org.apache.bcel.generic.RET;

/**
 * <p>Title: Cream</p>
 * <p>Description: 奶油类，用来包装食物</p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  14:08
 */
public class Cream extends Food {

    private Food food;

    public Cream() {

    }

    public Cream(Food food) {
        this.food = food;
    }

    @Override
    public String make() {
        return food.make() + "涂一层奶油";
    }

}
