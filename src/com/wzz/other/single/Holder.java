package com.wzz.other.single;

/**
 * @Date 2021/1/20 10:35
 * @created by wzz
 * <p>
 * 静态内部类 单例模式
 */
public class Holder {

    private Holder() {
    }

    public static Holder getInstance() {
        return InnerClass.HOLDER;
    }

    // 静态内部类
    static class InnerClass {
        private static final Holder HOLDER = new Holder();
    }

    public static void main(String[] args) {
        Holder instance = Holder.getInstance();
        Holder instance2 = Holder.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }
}
