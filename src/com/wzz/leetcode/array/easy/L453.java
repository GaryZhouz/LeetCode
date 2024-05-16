package com.wzz.leetcode.array.easy;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [1,2,3]
 * 输出：
 * 3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class L453 {

    public int minMoves(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int min = nums[0];
        // 题目中说的每次操作将会使 n - 1 个元素增加 1，可以联想到，这其实就是每次将一个元素减1
        // 那么为了让每个元素相等，最后必然会减到最小的那个元素的值
        // 所以只需要计算出每个元素减到最小元素的值的次数，再求和就是最终答案
        for (int num : nums) {
            count += num - min;
        }
        return count;
    }
}
