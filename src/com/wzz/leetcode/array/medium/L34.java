package com.wzz.leetcode.array.medium;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class L34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        result[1] = -1;
        twoMidSearch(0, nums.length - 1, result, target, nums);
        result[0] = result[0] == Integer.MAX_VALUE ? -1 : result[0];
        return result;
    }

    private void twoMidSearch(int left, int right, int[] result, int target, int[] nums) {
        if (left > right) {
            return;
        }
        int mid = left + (right - left) / 2;
        if (target == nums[mid]) {
            result[0] = Math.min(mid, result[0]);
            result[1] = Math.max(mid, result[1]);
            twoMidSearch(mid + 1, right, result, target, nums);
            twoMidSearch(left, mid - 1, result, target, nums);
        } else if (target > nums[mid]) {
            twoMidSearch(mid + 1, right, result, target, nums);
        } else {
            twoMidSearch(left, mid - 1, result, target, nums);
        }
    }
}
