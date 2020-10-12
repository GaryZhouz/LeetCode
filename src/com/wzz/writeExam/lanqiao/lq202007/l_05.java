package com.wzz.writeExam.lanqiao.lq202007;

import java.math.BigInteger;

/*
斐波那契数列满足 F1 = F2 = 1，从 F3 开始有 Fn = Fn−1 + Fn−2。请你计算
GCD(F2020; F520)，其中 GCD(A; B) 表示 A 和 B 的最大公约数。
 */
public class l_05 {

    public static BigInteger f(int a) {
        BigInteger[] sum = new BigInteger[a];
        sum[0] = BigInteger.valueOf(1);
        sum[1] = BigInteger.valueOf(1);
        for (int i = 2; i < a; i++) {
            sum[i] = sum[i - 1].add(sum[i - 2]);
        }
        return sum[a - 1];
    }

    public static void main(String[] args) {
        BigInteger f1 = f(2020);
        BigInteger f2 = f(520);
        System.out.println(f2.gcd(f1));
    }
}
