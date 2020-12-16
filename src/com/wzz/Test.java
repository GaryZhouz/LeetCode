package com.wzz;

/**
 * @Date 2020/12/9 18:26
 * @created by wzz
 */
public class Test {
    public static void main(String[] args) {
        int[] a = {-1, 1, 2, 1, 3, 5};

        int[] feb = feb(10);
        for (int i : feb) {
            System.out.print(i + " ");
        }

        System.out.println("\n" + feb2(10));
    }

    public static int[] feb(int n) {
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int feb2(int n) {
        if (n == 0 || n == 1) return 1;
        return feb2(n - 1) + feb2(n - 2);
    }

    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
