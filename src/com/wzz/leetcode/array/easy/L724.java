package com.wzz.leetcode.array.easy;

/*
给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

示例 1：
输入：
nums = [1, 7, 3, 6, 5, 6]
输出：3
解释：
索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
同时, 3 也是第一个符合要求的中心索引。

示例 2：
输入：
nums = [1, 2, 3]
输出：-1
解释：
数组中不存在满足此条件的中心索引。

说明：
nums 的长度范围为 [0, 10000]。
任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-pivot-index
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L724 {
    public static void main(String[] args) {
        System.out.println(new L724().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public int pivotIndex(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            int leftSum = getSumLeftOrRight(nums, i, "l");
            int rightSum = getSumLeftOrRight(nums, i, "r");
            if (leftSum == rightSum) {
                if (res == -1) res = i;
                res = Math.min(res, i);
            }
        }
        return res;
    }

    private int getSumLeftOrRight(int[] nums, int i, String l) {
        int num = 0;
        if (l.equals("l")) {
            for (int j = 0; j < i; j++) {
                num += nums[j];
            }
        } else if (l.equals("r")){
            for (int j = i + 1; j < nums.length; j++) {
                num += nums[j];
            }
        }
        return num;
    }
}
