package com.wzz.Array.easy;


/**
 * Author: Wzz
 * CreateTime: 2020/12/1 15:49
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *  
 * <p>
 * 说明：
 * <p>
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 */
public class L665 {
    public boolean checkPossibility(int[] nums) {
        //用于数组中存在的递减列表的数量
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt <= 1; i++) {//如果递减序列长度大于1 直接退出
            if (nums[i - 1] > nums[i]) {//存在一个递减序列
                cnt++;
                if (i - 2 >= 0 && nums[i - 2] > nums[i])
                    nums[i] = nums[i - 1];
            }
        }
        return cnt <= 1;
    }
}