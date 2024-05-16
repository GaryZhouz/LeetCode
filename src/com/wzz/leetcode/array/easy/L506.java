package com.wzz.leetcode.array.easy;

import java.util.*;

/**
 * @Date 2021/7/16 1:21 下午
 * @Created by zhouzhou.wang
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 * <p>
 * (注：分数越高的选手，排名越靠前。)
 * <p>
 * 示例 1:
 * <p>
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 提示:
 * <p>
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 */
public class L506 {

    public String[] findRelativeRanks(int[] score) {
        int length = score.length;
        int[] copy = new int[length];
        System.arraycopy(score, 0, copy, 0, copy.length);
        Arrays.sort(copy);
        Map<Integer, String> top = new HashMap<>();
        for (int i = 0, j = length; i < length; i++, j--) {
            if (i == length - 1) {
                top.put(copy[length - 1], "Gold Medal");
            } else if (i == length - 2) {
                top.put(copy[length - 2], "Silver Medal");
            } else if (i == length - 3) {
                top.put(copy[length - 3], "Bronze Medal");
            } else {
                top.put(copy[i], j + "");
            }
        }
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            result[i] = top.get(score[i]);
        }
        return result;
    }
}
