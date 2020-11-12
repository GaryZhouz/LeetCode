package com.wzz.writeExam.lanqiao.lanqiao_national_competition.ten;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Date 2020/11/11 12:52
 * @created by wzz
 * 我们称一个字符串 S 包含字符串 T 是指 T 是 S 的一个子序列，即可以从
 * 字符串 S 中抽出若干个字符，它们按原来的顺序组合成一个新的字符串与 T 完
 * 全一样。
 * 给定两个字符串 S 和 T，请问 T 中从第一个字符开始最长连续多少个字符
 * 被 S 包含？
 * 【输入格式】
 * 输入两行，每行一个字符串。第一行的字符串为 S，第二行的字符串为 T。
 * 两个字符串均非空而且只包含大写英文字母。
 * 【输出格式】
 * 输出一个整数，表示答案。
 * 【样例输入】
 * ABCDEABCD
 * AABZ
 * 【样例输出】
 * 3
 * 【评测用例规模与约定】
 * 对于 20% 的评测用例， 1 ≤ jTj ≤ jS j ≤ 20；
 * 对于 40% 的评测用例， 1 ≤ jTj ≤ jS j ≤ 100；
 * 对于所有评测用例， 1 ≤ jTj ≤ jS j ≤ 1000。
 */
public class _06 {
    static int max = 0;
    static String S;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        S = scanner.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (map.get(S.charAt(i)) != null) map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
            else map.put(S.charAt(i), 1);
        }

        String T = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < T.length(); i++) {
            stringBuffer.delete(0, stringBuffer.length());
            stringBuffer.append(T.charAt(i - 1));
            for (int j = i; j < T.length(); j++) {
                if (T.charAt(j - 1) <= T.charAt(j)) {
                    stringBuffer.append(T.charAt(j));//当前的递增串
                    max = Math.max(handle(stringBuffer.toString()), max);
                } else break;
            }
        }
        System.out.println(max);
    }

    /**
     * @param str 当前递增串
     */
    private static int handle(String str) {
        Map<Character, Integer> copy = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (copy.get(S.charAt(i)) != null) copy.put(S.charAt(i), copy.get(S.charAt(i)) + 1);
            else copy.put(S.charAt(i), 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (copy.get(str.charAt(i)) != null && copy.get(str.charAt(i)) != 0)
                copy.put(str.charAt(i), copy.get(str.charAt(i)) - 1);
            else //不存在该字符,直接返回
                return -1;
        }
        return str.length();
    }
}
