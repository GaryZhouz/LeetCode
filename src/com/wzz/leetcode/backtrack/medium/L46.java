package com.wzz.leetcode.backtrack.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
class L46 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> tempStorage = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        permutation(nums, 0, result, tempStorage);
        return result;
    }

    public void permutation(int[] nums, int index, List<List<Integer>> result, List<Integer> tempStorage) {
        if (tempStorage.size() == nums.length) {
            result.add(new ArrayList<>(tempStorage));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempStorage.contains(nums[i])) {
                    continue;
                }
                int num = nums[i];
                tempStorage.add(num);
                permutation(nums, index + 1, result, tempStorage);
                tempStorage.remove(index);
            }
        }
    }
}