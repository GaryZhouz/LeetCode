package com.wzz.leetcode.string.easy;

/**
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * <p>
 * 请你返回字符串的能量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 * 示例 2：
 * <p>
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 * 示例 3：
 * <p>
 * 输入：s = "triplepillooooow"
 * 输出：5
 * 示例 4：
 * <p>
 * 输入：s = "hooraaaaaaaaaaay"
 * 输出：11
 * 示例 5：
 * <p>
 * 输入：s = "tourist"
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 */
public class L1446 {
    public int maxPower(String s) {
        int max = 1;
        char[] chars = s.toCharArray();
        int sum = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                sum++;
            } else {
                max = Math.max(max, sum);
                sum = 1;
            }
        }
        return Math.max(max, sum);
    }
}
