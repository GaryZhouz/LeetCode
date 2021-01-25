package com.wzz.leetcode.other.factory.method;

/**
 * @Date 2021/1/20 11:28
 * @created by wzz
 */
public class Test {
    public static void main(String[] args) {
        ApplePhoneFactory applePhoneFactory = new ApplePhoneFactory();
        XiaoMiPhoneFactory xiaoMiPhoneFactory = new XiaoMiPhoneFactory();
        Phone apple = applePhoneFactory.getPhone();
        Phone xiaoMi = xiaoMiPhoneFactory.getPhone();
        apple.name();
        xiaoMi.name();
    }
}
