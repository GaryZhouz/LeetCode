package com.wzz.nowcoder;

/**
 * @Date 2021/1/26 13:12
 * @created by wzz
 */
public class 排序 {
    /**
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int L, int R) {
        if (L > R)
            return;
        int left = L;
        int right = R;
        int pivot = arr[left];
        while (left < right) {
            // 从右往左找到比主元小的
            while (left < right && arr[right] <= pivot)
                right--;
            arr[left] = arr[right];
            while (left < right && arr[left] >= pivot)
                left++;
            arr[right] = arr[left];
        }
        // 回溯主元
        arr[left] = pivot;
        quickSort(arr, L, left - 1);
        quickSort(arr, left + 1, R);
    }
}
