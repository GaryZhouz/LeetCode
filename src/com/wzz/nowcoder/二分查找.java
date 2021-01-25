package com.wzz.nowcoder;

/**
 * @Date 2021/1/25 9:30
 * @created by wzz
 */
public class 二分查找 {
    /**
     * 二分查找
     *
     *请实现有重复数字的升序数组的二分查找。
     * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_(int n, int v, int[] a) {
        if (v > a[n - 1]) {
            return n + 1;
        }
        int start = 0;
        int end = n - 1;
        int mid = start + (end - start) / 2;
        while (start < end) {
            if (a[mid] >= v) {
                end = mid;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return mid + 1;
    }
}
