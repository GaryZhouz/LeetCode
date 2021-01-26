package com.wzz.nowcoder;

/**
 * @Date 2021/1/26 16:02
 * @created by wzz
 */
public class 合并两个有序的数组 {
    /**
     * 给出两个有序的整数数组A和B，请将数组B合并到数组A中，变成一个有序的数组
     * 注意：
     * 可以假设A数组有足够的空间存放 B数组的元素， A和 B中初始的元素数目分别为 m和n
     */
    public void merge(int A[], int m, int B[], int n) {
        for (int i = m, j = 0; i < m + n; i++, j++) {
            A[i] = B[j];
        }
        quickSort(A, 0, m + n - 1);
    }

    /**
     * 快排
     *
     * @param a 数组
     * @param L 左侧
     * @param R 右侧
     */
    private void quickSort(int[] a, int L, int R) {
        if (L > R)
            return;
        int left = L;
        int right = R;
        int pivot = a[left];
        while (left < right) {
            while (left < right && a[right] >= pivot)
                right--;
            a[left] = a[right];
            while (left < right && a[left] <= pivot)
                left++;
            a[right] = a[left];
        }
        a[left] = pivot;
        quickSort(a, L, left - 1);
        quickSort(a, left + 1, R);
    }
}
