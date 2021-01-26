package com.wzz.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Date 2021/1/26 13:20
 * @created by wzz
 */
public class 最小的K个数 {
    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
     * <p>
     * 输入
     * [4,5,1,6,2,7,3,8],4
     * <p>
     * 返回值
     * [1,2,3,4]
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        Arrays.sort(input);
        ArrayList<Integer> res = new ArrayList<>();
        // 如果当前需要的最小的数 超过数组范围 直接返回空
        if (k > input.length)
            return res;
        for (int i = 0; i < Math.min(k, input.length); i++) {
            res.add(input[i]);
        }
        return res;
    }
}
