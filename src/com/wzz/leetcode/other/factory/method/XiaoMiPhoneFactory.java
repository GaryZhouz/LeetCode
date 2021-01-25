package com.wzz.leetcode.other.factory.method;

/**
 * @Date 2021/1/20 11:28
 * @created by wzz
 */
public class XiaoMiPhoneFactory implements PhoneFactory {
    @Override
    public Phone getPhone() {
        return new XiaoMi();
    }
}
