package com.wzz.nowcoder;

/**
 * @Date 2021/1/26 14:45
 * @created by wzz
 */
public class 跳台阶 {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * 示例1
     * 输入
     * 1
     * 返回值
     * 1
     * 示例2
     * 输入
     * 4
     * 返回值
     * 5
     */
    public static void main(String[] args) {
        System.out.println(rec(4));
    }

    public int JumpFloor(int target) {// 问题实际上是一个斐波拉契数列(非递归)
        int[] nums = new int[target + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[target];
    }

    // 递归方法实现
    public static int rec(int target) {
        if (target == 1)
            return 1;
        else if (target == 2)
            return 2;
        return rec(target - 1) + rec(target - 2);
    }
}
