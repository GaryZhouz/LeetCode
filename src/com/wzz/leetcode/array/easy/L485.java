package com.wzz.leetcode.array.easy;

/**
 * @Date 2021/7/15 1:31 下午
 * @Created by zhouzhou.wang
 * <p>
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的数组只包含 0 和 1 。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
public class L485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, result = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                result = Math.max(count, result);
                count = 0;
            }
        }
        return Math.max(count, result);
    }

}
