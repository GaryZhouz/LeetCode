package com.wzz.leetcode.Array.easy;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *  
 * <p>
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Offer53_1 {
    int result = 0;

    public int search(int[] nums, int target) {
        findNumberCount(nums, 0, nums.length - 1, target);
        return result;
    }

    private void findNumberCount(int[] nums, int start, int end, int target) {
        if (start > end) {
            return;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            result++;
            findNumberCount(nums, start, mid - 1, target);
            findNumberCount(nums, mid + 1, end, target);
        } else if (nums[mid] > target) {
            findNumberCount(nums, start, mid - 1, target);
        } else {
            findNumberCount(nums, mid + 1, end, target);
        }
    }
}
