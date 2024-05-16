package com.wzz.leetcode.array.easy;


import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[2]
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 */
public class L448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] count = new int[nums.length + 1];
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            count[num] += 1;
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }

}
