package com.wzz.leetcode.array.medium;

import java.util.Arrays;

/**
 * @Date 2021/7/25 11:21
 * @created by wzz
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 */
public class L45 {
    public int jump(int[] nums) {
        // dp 解法
        int n = nums.length;
        int[] f = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (nums[j] < i - j) {
                j++;
            }
            f[i] = f[j] + 1;
        }
        return f[n - 1];

        // 贪心解法
//        int max = 0;
//        int result = 0, end = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            // 每次选择这一步向后能到的最大距离
//            max = Math.max(max, nums[i] + i);
//            if (i == end) {
//                end = max;
//                result++;
//            }
//        }
//        return result;
    }

    public int jump2(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= i - j) {
                    dp[i] = dp[i] == 0 ? dp[j] + 1 : Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }
}
