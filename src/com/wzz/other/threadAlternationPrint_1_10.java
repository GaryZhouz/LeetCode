package com.wzz.other;

/**
 * @Date 2021/1/19 15:50
 * @created by wzz
 *
 * 线程交替执行 并输出1-10
 *
 * 线程1 输出1
 * 线程2 输出2
 * 线程1 输出3
 * 线程2 输入4
 * 以此内推
 */
public class threadAlternationPrint_1_10 {
    static class Resource {
        int num;

        public Resource(int num) {
            this.num = num;
        }

        public synchronized void increment() {
            num++;
            if (num == 11) {
                num = 1;
            }
            notify();
            System.out.println(num + ": " +Thread.currentThread().getName());
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Resource resource = new Resource(0);

        new Thread(() -> {
            while (true) {
                resource.increment();
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                resource.increment();
            }
        }, "t2").start();
    }
}
