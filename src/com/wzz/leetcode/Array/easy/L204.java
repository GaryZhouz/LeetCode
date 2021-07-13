package com.wzz.leetcode.Array.easy;

import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 5 * 106
 */
public class L204 {
    public int countPrimes(int n) {
        int result = 0;
        Boolean[] bitMap = new Boolean[n];
        // 填充数组
        Arrays.fill(bitMap, true);
        // 当前数字如果是素数，则他的n次幂一定不是素数，将其全部标记一下
        for (int i = 2; i * i < n; i++) {
            if (bitMap[i]) {
                for (int j = i * i; j < n; j += i) {
                    bitMap[j] = false;
                }
            }
        }
        for (int i = 2; i < bitMap.length; i++) {
            if (bitMap[i]) {
                result++;
            }
        }
        return result;
    }
}
