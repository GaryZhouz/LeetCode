package com.wzz.nowcoder;

import java.util.HashSet;
import java.util.Set;

/**
 * @Date 2021/1/26 15:50
 * @created by wzz
 */
public class 最长无重复子串 {

    /**
     * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
     * 示例1
     * 输入
     * 复制
     * [2,3,4,5]
     * 返回值
     * <p>
     * 4
     * 示例2
     * 输入
     * <p>
     * [2,2,3,4,3]
     * 返回值
     * <p>
     * 3
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        // 最大长度
        int max = 0;
        // 存放出现过的数字
        Set<Integer> hasNums = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            hasNums.clear();
            for (int j = i; j < arr.length; j++) {
                if (!hasNums.contains(arr[j])) {// 如果当前数字没出现过
                    hasNums.add(arr[j]);
                    max = Math.max(hasNums.size(), max);
                } else
                    break;
            }
        }
        return max;
    }
}
