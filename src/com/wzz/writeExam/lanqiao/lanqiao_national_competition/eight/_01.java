package com.wzz.writeExam.lanqiao.lanqiao_national_competition.eight;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Date 2020/11/12 15:43
 * @created by wzz
 * 平方十位数
 * 题目描述
 * 由0~9这10个数字不重复、不遗漏，可以组成很多10位数字。
 * 这其中也有很多恰好是平方数（是某个数的平方）。
 * <p>
 * 比如：1026753849，就是其中最小的一个平方数。
 * <p>
 * 请你找出其中最大的一个平方数是多少？
 * <p>
 * 注意：你需要提交的是一个10位数字，不要填写任何多余内容。
 */
public class _01 {
    public static void main(String[] args) {
        for (long i = 100000; i > 32000; i--) {
            long pow = i * i;
            if (check(String.valueOf(pow))) {
                System.out.println(pow);
                break;
            }
        }
    }

    private static boolean check(String pow) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            map.put(i + "", 1);
        }
        for (int i = 0; i < pow.length(); i++) {//0-9 出现多次
            if (map.get(pow.charAt(i) + "") != null) map.put(pow.charAt(i) + "", map.get(pow.charAt(i) + "") - 1);
            if (map.get(pow.charAt(i) + "") < 0) return false;
        }

        for (int i = 0; i <= 9; i++) {//检查是否每一个数都用到
            if (map.get(i + "") != 0) return false;
        }
        return true;
    }
}
