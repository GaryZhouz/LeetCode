package com.wzz.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Date 2021/2/1 15:09
 * @created by wzz
 */
public class 字符串的排列 {
    /**
     * 题目描述
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * 输入描述:
     * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
     * 示例1
     * 输入
     * "ab"
     * 返回值
     * ["ab","ba"]
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> strings = new ArrayList<>();
        fullPermutation(strings, str.toCharArray(), 0);
        Collections.sort(strings);
        return strings;
    }

    private void fullPermutation(ArrayList<String> strings, char[] chars, int start) {
        if (start == chars.length) {
            String currentString = Arrays.toString(chars)
                    .replaceAll("\\[", "")
                    .replaceAll("]", "")
                    .replaceAll(",", "")
                    .replaceAll(" ", "");
            if (!strings.contains(currentString))
                strings.add(currentString);
            return;
        }
        for (int i = start; i < chars.length; i++) {
            swap(chars, i, start);
            fullPermutation(strings, chars, start + 1);
            swap(chars, start, i);
        }

    }

    private void swap(char[] chars, int start, int i) {
        char temp = chars[start];
        chars[start] = chars[i];
        chars[i] = temp;
    }
}
