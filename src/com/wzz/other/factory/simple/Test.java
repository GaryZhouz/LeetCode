package com.wzz.other.factory.simple;

/**
 * @Date 2021/1/20 11:07
 * @created by wzz
 */
public class Test {
    public static void main(String[] args) {
        PhoneFactory phoneFactory = new PhoneFactory();
        Phone applePhone = phoneFactory.getApplePhone();
        Phone xiaoMi = phoneFactory.getXiaoMi();
        xiaoMi.name();
        applePhone.name();
    }
}
