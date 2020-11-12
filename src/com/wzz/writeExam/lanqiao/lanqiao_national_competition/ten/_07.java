package com.wzz.writeExam.lanqiao.lanqiao_national_competition.ten;

import java.util.Scanner;

/**
 * @Date 2020/11/11 13:18
 * @created by wzz
 * 在一个 N × N 的点阵上，取其中 4 个点恰好组成一个正方形的 4 个顶点，
 * 一共有多少种不同的取法？
 * 由于结果可能非常大，你只需要输出模 109 + 7 的余数。
 * 如上图所示的正方形都是合法的。
 * 【输入格式】
 * 输入包含一个整数 N。
 * 【输出格式】
 * 输出一个整数代表答案。
 * 【样例输入】
 * 4
 * 【样例输出】
 * 20
 * 【数据规模与约定】
 * 对于所有评测用例， 2 ≤ N ≤ 1000000。
 */
public class _07 {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        long n = new Scanner(System.in).nextInt();
        long res = ((n - 1) * (n - 1)) % mod;
        for (int i = 2; i < n; i++)
            res = (res + (((n - i) * (n - i)) % mod) * i) % mod;
        System.out.println(res);
    }

}
