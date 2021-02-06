package com.wzz.nowcoder;

/**
 * @Date 2021/2/6 10:04
 * @created by wzz
 */
public class 数学实验 {
    /**
     * 题目描述
     * 给出一个数字n，需要不断地将所有数位上的值做乘法运算，直至最后数字不发生变化为止。
     * 问最后生成的数字为多少？
     * 示例1
     * 输入
     * 复制
     * 10
     * 返回值
     * 复制
     * 0
     * 示例2
     * 输入
     * 复制
     * 55
     * 返回值
     * 复制
     * 0
     * 说明
     * 55 -> 5 * 5 = 25 -> 2 * 5 = 10 -> 1 * 0 = 0
     * 备注:
     * 1\leq n\leq 10^{18}1≤n≤10
     * 18
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n long长整型 老师给牛牛的数字
     * @return int整型
     */
    public int mathexp(long n) {
        do {
            long m = 1;
            while (n != 0) {
                m = m * (n % 10);
                n = n / 10;
            }
            n = m;
        } while (n >= 10);
        return (int) n;
    }
}
