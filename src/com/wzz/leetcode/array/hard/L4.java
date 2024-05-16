package com.wzz.leetcode.array.hard;

import java.util.Arrays;

/**
 * @Date 2021/2/1 13:34
 * @created by wzz
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 */
public class L4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] nums = new int[len];
        double res = 0;
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        if (len - nums1.length >= 0)
            System.arraycopy(nums2, nums1.length, nums, nums1.length, len - nums1.length);
        Arrays.sort(nums);
        if (len % 2 == 0) {
            res = (double) (nums[len / 2] + nums[len / 2 - 1]) / 2;
        } else
            res = nums[len / 2];
        return res;
    }
}
