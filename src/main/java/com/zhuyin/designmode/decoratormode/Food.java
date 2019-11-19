package com.zhuyin.designmode.decoratormode;

/**
 * <p>Title: Food</p>
 * <p>Description: 被装饰对象</p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  13:47
 */
public class Food {

    private String foodName;

    public Food() {
    }

    public Food(String foodName) {
        this.foodName = foodName;
    }

    public String make() {
        return foodName;
    }
}
