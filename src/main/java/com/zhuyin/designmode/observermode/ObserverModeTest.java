package com.zhuyin.designmode.observermode;

/**
 * <p>Title: ObserverModeTest</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  13:13
 */
public class ObserverModeTest {

    public static void main(String[] args) {
        XiaoMei xiaoMei = new XiaoMei();

        LaoWang laoWang = new LaoWang();
        LaoLi laoLi = new LaoLi();

        xiaoMei.addObservers(laoWang).add(laoLi);

        xiaoMei.notifyAllObservers("谁来陪我逛街？");
    }

}
