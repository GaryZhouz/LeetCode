package com.wzz.writeExam.lanqiao.lanqiao_national_competition.ten;

/**
 * @Date 2020/11/11 10:54
 * @created by wzz
 * <p>
 * 学习了约数后，小明对于约数很好奇，他发现，给定一个正整数 t，总是可
 * 以找到含有 t 个约数的整数。小明对于含有 t 个约数的最小数非常感兴趣，并
 * 把它定义为 S t 。
 * 例如 S 1 = 1, S 2 = 2, S 3 = 4, S 4 = 6， · · · 。
 * 现在小明想知道，前 60 个 S i 的和是多少？即 S 1 + S 2 + · · · + S 60 是多少？
 */
public class _05 {
    public static void main(String[] args) {
        long res = 0;
        for (int i = 1; i <= 60; i++) {
            res += handle(i);
        }
        System.out.println(res);
    }

    private static int handle(int i) {
        int sum;
        for (int j = 1; j < 100000; j++) {
            sum = 0;
            for (int k = 1; k <= j; k++) {
                if (j % k == 0) sum++;
                if (sum == i) return j;
            }
        }
        return -1;
    }
}
