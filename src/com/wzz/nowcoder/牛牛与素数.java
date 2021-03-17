package com.wzz.nowcoder;

/**
 * @Date 2021/2/10 11:59
 * @created by wzz
 */
public class 牛牛与素数 {
    /**
     * 题目描述
     * 牛牛特别喜欢数字7，他想知道如果一个数字n乘以7是否是一个素数。
     * 给定一个数字n，如果该数乘以7是一个素数，返回"YES"，否则，返回"NO"。
     * 示例1
     * 输入
     * 复制
     * 1
     * 返回值
     * 复制
     * "YES"
     * 备注:
     * 1 \leq n \leq 10^81≤n≤10
     * 8
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 给定一个数字n，如果该数乘以7是一个素数，返回"YES"，否则，返回"NO"。
     *
     * @param n int整型 代表题目中的n
     * @return string字符串
     */
    public String solve(int n) {
        if (n == 1) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
