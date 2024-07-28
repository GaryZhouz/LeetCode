package com.wzz.leetcode.math.easy;


/**
 * 编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中
 * 设置位
 * 的个数（也被称为汉明重量）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 11
 * 输出：3
 * 解释：输入的二进制串 1011 中，共有 3 个设置位。
 * 示例 2：
 * <p>
 * 输入：n = 128
 * 输出：1
 * 解释：输入的二进制串 10000000 中，共有 1 个设置位。
 * 示例 3：
 * <p>
 * 输入：n = 2147483645
 * 输出：30
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 30 个设置位。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果多次调用这个函数，你将如何优化你的算法？
 */
public class L191 {
    public static int hammingWeight(int n) {
        int  count = 0;
        String str = Integer.toString(n, 2);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(128));
    }
}
