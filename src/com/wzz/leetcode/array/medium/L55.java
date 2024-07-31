package com.wzz.leetcode.array.medium;

/**
 * @Date 2021/7/25 10:47
 * @created by wzz
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */
public class L55 {
    public boolean canJump(int[] nums) {
        // dp 解法
//        boolean[] dp = new boolean[nums.length];
//        dp[0] = true;
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] >= (i - j) && dp[i - 1]) {
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }
//        return dp[nums.length - 1];

        // 贪心解法
        if (nums.length == 1) {
            return true;
        }
        int max = nums[0];
        for (int i = 0; i <= max; i++) {
            // 每次选择这一步向后能到的最大距离
            max = Math.max(max, nums[i] + i);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果某个节点的索引大于他和他之前最大能跳的长度则直接返回false
            if (i > max) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }
}
