package com.zhuyin.reflect.instance2;

public class SetPropertyDemo {

    public static void main(String[] args) throws Exception {
        Student s = new Student();
        //通过此方法来给任意类的私有成员变量赋值
        SetProperty.setObjectProperty(s, "name", "张三");
        SetProperty.setObjectProperty(s, "age", 24);
        System.out.println("1——>" + s);

        System.out.println("-----------------------------------");

        //通过此方法来访问任意类中的私有方法
        SetProperty.setMethodAccessible(s, "show");

    }

}


class Student {
    public String name;
    public int age;

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    private String show() {
        System.out.println("私有方法");
        return "success";
    }
}