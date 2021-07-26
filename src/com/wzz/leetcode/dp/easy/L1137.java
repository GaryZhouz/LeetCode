package com.wzz.leetcode.dp.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Date 2021/7/22 3:31 下午
 * @Created by zhouzhou.wang
 * <p>
 * 泰波那契序列 Tn 定义如下： 
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 * <p>
 * <p>
 */
public class L1137 {
    public int tribonacci(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        result.add(1);
        for (int i = 3; i <= n; i++) {
            int value = result.get(i - 1) + result.get(i - 2) + result.get(i - 3);
            result.add(value);
        }
        return result.get(n);
    }
}
