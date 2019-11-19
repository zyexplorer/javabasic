package com.zhuyin.designmode.observermode;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * <p>Title: XiaoMei</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  13:07
 */
public class XiaoMei {

    private List<Person> observers = Lists.newArrayList();

    public XiaoMei() {
    }

    public List<Person> addObservers(Person person) {
        observers.add(person);
        return observers;
    }

    public void notifyAllObservers(String msg) {
        observers.forEach(person -> person.getMessage(msg));
    }
}
