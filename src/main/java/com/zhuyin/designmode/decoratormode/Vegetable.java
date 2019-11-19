package com.zhuyin.designmode.decoratormode;

/**
 * <p>Title: Vegetable</p>
 * <p>Description: 蔬菜类，用来包装食物</p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  14:11
 */
public class Vegetable extends Food {

    private Food food;

    public Vegetable() {

    }

    public Vegetable(Food food) {
        this.food = food;
    }

    @Override
    public String make() {
        return food.make() + "裹一层蔬菜";
    }
}
