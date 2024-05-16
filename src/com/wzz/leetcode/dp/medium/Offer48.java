package com.wzz.leetcode.dp.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 * <p>
 * 提示：
 * <p>
 * s.length <= 40000
 * 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        List<Character> characters = new ArrayList<>();
        characters.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!characters.contains(s.charAt(i))) {
                dp[i] = dp[i - 1] + 1;
                characters.add(s.charAt(i));
            } else {
                // 取相同字符的索引
                int index = characters.indexOf(s.charAt(i));
                // 从相同字符的后一个开始计数
                int startNum = characters.size() - 1 - index;
                dp[i] = startNum + 1;
                // 截取那个字符后面的所有字符
                characters = characters.subList(index + 1, characters.size());
                characters.add(s.charAt(i));
            }
        }
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }
}
