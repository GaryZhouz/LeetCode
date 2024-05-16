package com.wzz.leetcode.array.easy;

/**
 * @Date 2021/6/9 18:35
 * @created by wzz
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：nums = [-100000]
 * 输出：-100000
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L53 {
    public int maxSubArray(int[] nums) {
        int preSum = 0, maxAns = nums[0];
        for (int temp : nums) {
            // 记录前面的所有和 是否 有当前数字大(如果是当前数字大 则从当前数字继续累加)
            preSum = Math.max(temp + preSum, temp);
            // 前面最大的和 和 当前值比较
            maxAns = Math.max(maxAns, preSum);
        }
        return maxAns;
    }
}
