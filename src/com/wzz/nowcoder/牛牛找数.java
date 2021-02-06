package com.wzz.nowcoder;

/**
 * @Date 2021/2/6 10:01
 * @created by wzz
 */
public class 牛牛找数 {
    /**
     * 题目描述
     * 牛牛有两个数a和b，他想找到一个大于a且为b的倍数的最小整数，只不过他算数没学好，不知道该怎么做，现在他想请你帮忙。
     * 给定两个数a和b，返回大于a且为b的倍数的最小整数。
     * 示例1
     * 输入
     * 复制
     * 3,2
     * 返回值
     * 复制
     * 4
     * 说明
     * 大于3且为2的倍数的最小整数为4。
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 给定两个数a和b，返回大于a且为b的倍数的最小整数。​
     *
     * @param a int整型 代表题目中描述的a
     * @param b int整型 代表题目中描述的b
     * @return int整型
     */
    public int findNumber(int a, int b) {
        int i = a / b;
        return (i + 1) * b;
    }
}
