package com.wzz.other.factory.method;

/**
 * @Date 2021/1/20 11:28
 * @created by wzz
 */
public class ApplePhoneFactory implements PhoneFactory {
    @Override
    public Phone getPhone() {
        return new ApplePhone();
    }
}
