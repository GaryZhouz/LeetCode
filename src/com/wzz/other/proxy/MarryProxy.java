package com.wzz.other.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Date 2020/11/29 13:59
 * @created by wzz
 */
public class MarryProxy implements InvocationHandler {

    //我们需要代理的对象
    private Object target;

    //传入需要代理的对象
    public MarryProxy(Object target) {
        this.target = target;
    }

    //代理的具体落地实现
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("结婚前的" + method.getName() + "方法");
        Object result = method.invoke(target, args);
        System.out.println("结婚后的" + method.getName() + "方法");
        return result;
    }
}
