package com.wzz.nowcoder;

/**
 * @Date 2021/2/5 21:21
 * @created by wzz
 */
public class 寻找峰值 {
    /**
     * 题目描述
     * 山峰元素是指其值大于或等于左右相邻值的元素。给定一个输入数组nums，任意两个相邻元素值不相等，数组可能包含多个山峰。找到索引最大的那个山峰元素并返回其索引。
     * <p>
     * 假设 nums[-1] = nums[n] = -∞。
     * <p>
     * 示例1
     * 输入
     * <p>
     * [2,4,1,2,7,8,4]
     * 返回值
     * <p>
     * 5
     * 寻找最后的山峰
     *
     * @param a int整型一维数组
     * @return int整型
     */
    public int solve(int[] a) {
        int max = -1;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] >= a[i - 1] && a[i] >= a[i + 1])
                max = Math.max(max, i);
        }
        if (a[a.length - 1] >= a[a.length - 2])
            max = a.length - 1;
        return max;
    }
}
