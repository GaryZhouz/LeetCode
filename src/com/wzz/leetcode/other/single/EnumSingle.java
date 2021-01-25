package com.wzz.leetcode.other.single;

/**
 * @Date 2021/1/20 10:53
 * @created by wzz
 */
public enum EnumSingle {

    INSTANCE;

    public static EnumSingle getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        EnumSingle instance = EnumSingle.getInstance();
        EnumSingle instance2 = EnumSingle.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }
}
