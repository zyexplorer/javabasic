package com.zhuyin.designmode.decoratormode;

/**
 * <p>Title: DecoratorModeTest</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  14:12
 */
public class DecoratorModeTest {

    public static void main(String[] args) {
        Food basicFood = new Food("火腿肠");
        Food food = new Vegetable(new Bread(new Cream(basicFood)));
        System.out.println(food.make());
    }

}
