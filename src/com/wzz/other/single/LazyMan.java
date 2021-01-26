package com.wzz.other.single;

/**
 * @Date 2021/1/20 10:43
 * @created by wzz
 * <p>
 * 懒汉式单例 双重锁监测机制
 */
public class LazyMan {

    private static boolean flag = false;

    public LazyMan() {
        synchronized (LazyMan.class) {
            if (!flag)// 当前还未实例对象
                flag = true;
            else
                throw new RuntimeException("请不要破坏单例!");
        }
    }

    // volatile防止指令重拍
    private volatile static LazyMan lazyMan;

    public static LazyMan getInstance() {
        synchronized (LazyMan.class) {
            if (lazyMan == null)
                lazyMan = new LazyMan();
        }
        return lazyMan;
    }

    public static void main(String[] args) {
        LazyMan instance = LazyMan.getInstance();
        LazyMan instance2 = LazyMan.getInstance();
        System.out.println(instance);
        System.out.println(instance2);

        LazyMan lazyMan = new LazyMan();
        LazyMan lazyMan2 = new LazyMan();
        System.out.println(lazyMan);
        System.out.println(lazyMan2);
    }
}
