package com.zhuyin.designmode.decoratormode;

/**
 * <p>Title: Bread</p>
 * <p>Description: 面包类，用来包装食物</p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  13:50
 */
public class Bread extends Food {

    private Food food;

    public Bread() {

    }

    public Bread(Food food) {
        this.food = food;
    }

    @Override
    public String make() {
        return food.make() + "包一层面包";
    }
}
