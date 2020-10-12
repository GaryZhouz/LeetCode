package com.wzz.writeExam.lanqiao.lq202007;

import java.math.BigInteger;
import java.util.Scanner;

/*
给定正整数 n, 求 18 + 28 + · · · + n8 mod 123456789 。其中 mod 表示取
余。
【输入格式】
输入的第一行包含一个整数 n。
【输出格式】
输出一行，包含一个整数，表示答案。
【样例输入】
2
【样例输出】
257
【样例输入】
987654
【样例输出】
43636805
【评测用例规模与约定】
对于 20% 的评测用例， 1 ≤ n ≤ 20。
对于 60% 的评测用例， 1 ≤ n ≤ 1000。
对于所有评测用例， 1 ≤ n ≤ 1000000。
 */
public class l_07 {

    public static BigInteger f(int n) {
        BigInteger sum = BigInteger.valueOf(0);
        for (int i = 1; i <= n; i++) {
            sum = sum.add(pow(i, 8));
        }
        return sum;
    }

    public static BigInteger pow(int x, int y) {
        BigInteger num = BigInteger.valueOf(x);
        for (int i = 0; i < y - 1; i++) {
            num = num.multiply(BigInteger.valueOf(x));
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        BigInteger f = f(i);
        BigInteger mod = f.mod(BigInteger.valueOf(123456789));
        System.out.println(mod.toString());
    }
}
