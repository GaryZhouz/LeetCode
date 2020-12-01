package com.wzz.other;

import java.util.Random;

/**
 * @Date 2020/11/23 14:43
 * @created by wzz
 * 快速排序
 */
public class Sort {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 3, 4, -1};
        System.out.println("冒泡排序:");
        quickSort(a, 0, a.length - 1);
        print(a);

        System.out.println("\n=================");

        System.out.println("冒泡排序:");
        maoPao(a);
        print(a);

        System.out.println("\n=================");

        System.out.println("选择排序:");
        selectSort(a);
        print(a);

        System.out.println("\n=================");

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
                if (nums[i] > nums[j])
                    swap(nums, j, i);
            }
        }
    }

    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private static void print(int[] a) {
        for (int value : a) {
            System.out.print(value + " ");
        }
    }
}
