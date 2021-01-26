package com.wzz.other.factory.simple;

/**
 * @Date 2021/1/20 11:05
 * @created by wzz
 */
public class PhoneFactory {

    public static Phone getPhone(String phoneName) {
        if (phoneName.equals("苹果")) {
            return new ApplePhone();
        } else if (phoneName.equals("小米")) {
            return new XiaoMi();
        }
        return null;
    }

    public Phone getApplePhone() {
        return new ApplePhone();
    }

    public Phone getXiaoMi() {
        return new XiaoMi();
    }
}
