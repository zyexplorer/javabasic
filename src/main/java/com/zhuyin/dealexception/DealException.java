package com.zhuyin.dealexception;

/**
 * <p>Title: DealException.java</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @version v1.0
 * @date 2018年5月5日  下午1:52:29
 */
public class DealException {

    public static void main(String[] args) {

        boolean flag = false;
        int n = 1;

        do {
            try {
                System.out.println(n);
                @SuppressWarnings("unused")
                int a = 1 / 0;
                doBuss();
                flag = true;
            } catch (Exception e) {
                n++;
            } finally {
                if (flag) {
                    System.out.println("业务逻辑处理正常，跳出循环");
                    break;
                }
            }
        } while (n <= 5);


        if (2 == 2 || 1 / 0 == 1) {
            System.out.println("进入if判断");
        }
    }

    private static void doBuss() {
        System.out.println("处理一些业务逻辑");
    }
}
