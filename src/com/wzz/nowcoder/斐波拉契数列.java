package com.wzz.nowcoder;

/**
 * @Date 2021/2/4 10:14
 * @created by wzz
 */
public class 斐波拉契数列 {

    public int Fibonacci(int n) {
        int[] arr = new int[39];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }
}
