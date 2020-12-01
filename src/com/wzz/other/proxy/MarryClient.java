package com.wzz.other.proxy;

import java.lang.reflect.Proxy;

/**
 * @Date 2020/11/29 14:03
 * @created by wzz
 */
public class MarryClient {
    public static void main(String[] args) {
        //需要代理的接口的实现类
        MarryImpl marry = new MarryImpl();
        //实例化代理对象,并将需要代理对象的信息传递进去
        MarryProxy marryProxy = new MarryProxy(marry);
        //通过proxy代理类动态创建代理实例
        Marry m = (Marry) Proxy.newProxyInstance(marry.getClass().getClassLoader(), marry.getClass().getInterfaces(), marryProxy);
        //执行创建出来的代理实例的方法
        m.make();
        m.marry();
    }
}
