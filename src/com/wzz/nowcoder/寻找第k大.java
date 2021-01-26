package com.wzz.nowcoder;

import java.util.Arrays;

/**
 * @Date 2021/1/26 14:41
 * @created by wzz
 */
public class 寻找第k大 {
    /**
     * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
     * <p>
     * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
     * <p>
     * 示例1
     * 输入
     * [1,3,5,2,2],5,3
     * <p>
     * 返回值
     * 2
     *
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth(int[] a, int n, int K) {
        Arrays.sort(a);
        return a[n - K];
    }
}
