package com.wzz.leetcode.array.easy;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * <p>
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * <p>
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 示例 3：
 * <p>
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -100 <= nums[i] <= 100
 * 1 <= k <= 104
 */
public class L1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < k; ) {
            if (nums[0] < 0) {
                nums[0] = -nums[0];
                k--;
            } else if (nums[0] > 0) {
                if (k % 2 != 0) {
                    nums[0] = -nums[0];
                }
                break;
            } else {
                k--;
            }
            Arrays.sort(nums);
        }
        return Arrays.stream(nums).sum();
    }
}
