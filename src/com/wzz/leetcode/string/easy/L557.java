package com.wzz.leetcode.string.easy;

/**
 * @Date 2021/7/25 9:47
 * @created by wzz
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 * <p>
 * 提示：
 * <p>
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class L557 {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s1 : arr) {
            reverseString(s1.toCharArray(), stringBuilder);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
    }

    private void reverseString(char[] s, StringBuilder stringBuilder) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        for (char c : s) {
            stringBuilder.append(c);
        }
    }
}
