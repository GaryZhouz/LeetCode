package com.wzz.other.proxy;

/**
 * @Date 2020/11/29 13:58
 * @created by wzz
 */
public class MarryImpl implements Marry {
    @Override
    public void marry() {
        System.out.println("我就要结婚啦!");
    }

    @Override
    public void make() {
        System.out.println("做一些有意义的事情!");
    }
}
