package com.wzz.nowcoder;

/**
 * @Date 2021/2/5 20:02
 * @created by wzz
 */
public class 进制转换 {
    /**
     * 进制转换
     *
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve(int M, int N) {
        return Integer.toString(M, N).toUpperCase();
    }
}
