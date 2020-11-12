package com.wzz.writeExam.lanqiao.lanqiao_national_competition.ten;

/**
 * @Date 2020/11/11 10:02
 * @created by wzz
 * 将 2019 拆分为若干个两两不同的完全平方数之和，一共有多少种不同的方
 * 法？
 * 注意交换顺序视为同一种方法，例如 13(平方)2 + 25 2 + 35 2 = 2019 与 13 2 + 35 2 +
 * 25 2 = 2019 视为同一种方法。
 */
public class _02 {
    static int sum = 0;

    public static void main(String[] args) {
        handle(1, 45, 2019);
        System.out.println(sum);
    }

    /**
     * @param x       开始数的位置,从1开始
     * @param y       最大的数的位置, 45 * 45 > 2019 所以是45
     * @param current 当前数的大小
     */
    private static void handle(int x, int y, int current) {
        if (current < 0) return;
        if (current == 0) {
            sum++;
            return;
        }
        for (int i = x; i < y; i++) {
            //每次开始的数字位置+1 防止重复, 最大的数字不变,当前的数字一直递减
            handle(i + 1, y, current - (int) Math.pow(i, 2));
        }
    }

}
