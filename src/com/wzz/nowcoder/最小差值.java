package com.wzz.nowcoder;

/**
 * @Date 2021/2/5 21:40
 * @created by wzz
 */
public class 最小差值 {
    /**
     * 题目描述
     * 给你一个数组aa，请你求出数组a中任意两个元素间差的绝对值的最小值。(2\leq len(a) \leq 10^3)(2≤len(a)≤10
     * 3
     * )
     * 示例1
     * 输入
     * 复制
     * [1,2,4]
     * 返回值
     * 复制
     * 1
     * 示例2
     * 输入
     * 复制
     * [1,3,1]
     * 返回值
     * 复制
     * 0
     * 备注:
     * a_ia
     * i
     * ​
     * 在int范围内，且保证答案在int范围内
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求最小差值
     *
     * @param a int整型一维数组 数组a
     * @return int整型
     */
    public int minDifference(int[] a) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int target = a[j] - a[i];
                min = Math.min(Math.abs(target), min);
            }
        }
        if (min < 0) {
            min = Integer.MAX_VALUE;
        }
        return min;
    }
}
