package com.wzz.leetcode.other.single;

/**
 * @Date 2021/1/20 10:40
 * @created by wzz
 *
 * 饿汉式单例模式
 */
public class Hungry {

    private static final Hungry HUNGRY = new Hungry();

    public static Hungry getInstance() {
        return HUNGRY;
    }

    public static void main(String[] args) {
        Hungry instance = Hungry.getInstance();
        Hungry instance2 = Hungry.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }
}
