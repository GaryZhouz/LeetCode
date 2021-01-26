package com.wzz.nowcoder;

/**
 * @Date 2021/1/26 14:58
 * @created by wzz
 */
public class 子数组的最大累加和 {

    /**
     * 给定一个数组arr，返回子数组的最大累加和
     * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
     * 题目保证没有全为负数的数据
     * [要求]
     * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
     * <p>
     * 示例1
     * 输入
     * [1, -2, 3, 5, -2, 6, -1]
     * 返回值
     * 12
     * <p>
     * max sum of the subarray
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        int max = Integer.MIN_VALUE;
        // 记录每一次加之后的值
        int cur = 0;
        for (int value : arr) {
            cur += value;
            max = Math.max(cur, max);
            cur = Math.max(cur, 0);
        }
        return max;
    }
}
