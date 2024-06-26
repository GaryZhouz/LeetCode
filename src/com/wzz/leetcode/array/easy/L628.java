package com.wzz.leetcode.array.easy;

import java.util.Arrays;

/*
给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

示例 1:
输入: [1,2,3]
输出: 6

示例 2:
输入: [1,2,3,4]
输出: 24

注意:
给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3] >
                nums[0] * nums[1] * nums[nums.length - 1] ?
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3] : nums[0] * nums[1] * nums[nums.length - 1];
    }
}
