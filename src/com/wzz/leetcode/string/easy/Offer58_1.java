package com.wzz.leetcode.string.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * <p>
 * 注意：此题对比原题有改动
 */
public class Offer58_1 {
    public String reverseWords(String s) {
//        return methodByStingBuilder(s);
        return methodByStack(s);
    }

    private String methodByStack(String s) {
        Stack<String> stack = new Stack<>();
        s = s.trim();
        String[] words = s.split("\\s+");
        stack.addAll(Arrays.stream(words).collect(Collectors.toList()));
        List<String> list = new ArrayList<>(stack);
        Collections.reverse(list);
        return String.join(" ", list);
    }

    private String methodByStingBuilder(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            stringBuilder.append(words[i])
                    .append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() > 0 ? stringBuilder.length() - 1 : 0);
    }
}
