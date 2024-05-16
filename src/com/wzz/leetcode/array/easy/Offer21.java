package com.wzz.leetcode.array.easy;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        int leftPoint = 0, rightPoint = nums.length - 1;
        while (leftPoint < rightPoint) {
            if (nums[leftPoint] % 2 == 0 && nums[rightPoint] % 2 != 0) {
                int temp = nums[leftPoint];
                nums[leftPoint] = nums[rightPoint];
                nums[rightPoint] = temp;
            } else if (nums[leftPoint] % 2 == 0) {
                rightPoint--;
            } else if (nums[rightPoint] % 2 == 0) {
                leftPoint++;
            }
        }
        return nums;
    }
}
