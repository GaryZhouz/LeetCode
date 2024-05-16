package com.wzz.leetcode.math.easy;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 *
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 */
public class Offer10_1 {
    public int fib(int n) {
        if (n == 0) {
            return n;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;
        for (int i = 3; i <= n; i++) {
            result[i] = (result[i - 2] + result[i - 1]) % 1_000_000_007;
        }
        return result[n];
    }
}
