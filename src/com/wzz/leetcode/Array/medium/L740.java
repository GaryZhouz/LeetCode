package com.wzz.leetcode.Array.medium;

import java.util.Arrays;

/**
 * @Date 2021/7/24 14:03
 * @created by wzz
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 */
public class L740 {
    /**
     * 首先，我们先明确一个概念，就是每个位置上的数字是可以在两种前结果之上进行选择的：
     * <p>
     * 如果你不删除当前位置的数字，那么你得到就是前一个数字的位置的最优结果。
     * 如果你觉得当前的位置数字i需要被删，那么你就会得到i - 2位置的那个最优结果加上当前位置的数字乘以个数。
     * 以上两个结果，你每次取最大的，记录下来，然后答案就是最后那个数字了。
     * <p>
     * 如果你看到现在有点迷糊，那么我们先把数字进行整理一下。
     * <p>
     * 我们在原来的 nums 的基础上构造一个临时的数组 all，这个数组，以元素的值来做下标，下标对应的元素是原来的元素的个数。
     * <p>
     * 举个例子：
     * <p>
     * nums = [2, 2, 3, 3, 3, 4]
     * <p>
     * 构造后：
     * <p>
     * all=[0, 0, 2, 3, 1];
     * <p>
     * 就是代表着 22 的个数有两个，33 的个数有 33 个，44 的个数有 11 个。
     */
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int[] countArr = new int[nums[nums.length - 1] + 1];
        for (int num : nums) {
            countArr[num] += 1;
        }
        int[] dp = new int[nums[nums.length - 1] + 1];
        dp[1] = countArr[1];
        dp[2] = Math.max(dp[1], countArr[2] * 2);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * countArr[i]);
        }
        return dp[nums[nums.length - 1] + 1];
    }
}
