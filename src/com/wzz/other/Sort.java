package com.wzz.other;

import java.util.Arrays;
import java.util.Random;

/**
 * @Date 2020/11/23 14:43
 * @created by wzz
 * 快速排序
 */
public class Sort {
    static int[] a = {1, -1, 2, 1, 3, 5};

    public static void main(String[] args) {
        System.out.println("快速排序:");
        quickSort(a, 0, a.length - 1);
        print();

        System.out.println("\n=================");

        System.out.println("冒泡排序:");
        maoPao(a);
        print();

        System.out.println("\n=================");

        System.out.println("选择排序:");
        selectSort(a);
        print();

        System.out.println("\n=================");

        System.out.println("插入排序:");
        insert_sort(a);
        print();

        System.out.println("\n堆排序:");
        heap_sort(a, a.length);
        print();
    }

    //快速排序
    public static void quickSort(int[] nums, int L, int R) {
        if (L > R) return;
        int left = L;
        int right = R;
        //取最左侧的元素作为主元
        int pivot = nums[left];
        while (left < right) {
            //先从右往左找到比当前主元小的元素
            while (left < right && pivot <= nums[right])
                right--;
            //找到后放到左边去
            nums[left] = nums[right];
            //再从左往右找比当前主元大的元素
            while (left < right && pivot >= nums[left])
                left++;
            //找到之后放入右边去
            nums[right] = nums[left];
        }
        //循环结束后left和right是相等的
        //还原主元
        nums[left] = pivot;
        // 递归操作
        quickSort(nums, L, left - 1);
        quickSort(nums, left + 1, R);
    }

    //冒泡排序
    public static void maoPao(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (nums[j] > nums[j + 1])
                    swap(nums, j, j + 1);
            }
        }
    }

    //选择排序
    public static void selectSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, j, i);
                }
            }
        }
    }

    //插入排序
    public static void insert_sort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] > nums[j])
                    swap(nums, j - 1, j);
            }
        }
    }

    //当列表第一个是以下标0开始，结点下标为i,左孩子则为2*i+1,
    // 右孩子下标则为2*i+2,若下标以1开始，左孩子则为2*i,右孩子则为2*i+１
    public static void heapAdjust(int[] a, int s, int m) {
        int key = a[s];
        for (int j = 2 * s + 1; j <= m; j = 2 * j + 1) {
            if (j < m && a[j] <= a[j + 1])
                ++j;
            if (a[j] <= key)
                break;
            a[s] = a[j];
            s = j;
        }
        a[s] = key;
    }

    public static void heap_sort(int[] a, int size) {
        //初始建堆,从最后一个非叶子节点开始
        for (int i = size / 2 - 1; i >= 0; --i) {
            heapAdjust(a, i, size - 1);
        }
        //取堆顶，并且调整
        for (int i = size - 1; i > 0; --i) {
            swap(a, 0, i);
            heapAdjust(a, 0, i - 1);
        }

    }

    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private static void print() {
        for (int value : a) {
            System.out.print(value + " ");
        }
        // 还原数组
        a = new int[]{1, -1, 2, 1, 3, 5};
    }
}
