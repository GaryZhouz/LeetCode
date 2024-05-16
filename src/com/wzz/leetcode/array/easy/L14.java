package com.wzz.leetcode.array.easy;


/**
 * @Date 2021/7/27 19:55
 * @created by wzz
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class L14 {
    public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        String minStr = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            min = Math.min(str.length(), min);
        }
        for (String str : strs) {
            if (str.length() == min) {
                minStr = str;
            }
        }
        outer:
        for (int i = 0; i < minStr.length(); i++) {
            for (String str : strs) {
                if (str.charAt(i) != minStr.charAt(i)) {
                    break outer;
                }
            }
            stringBuilder.append(minStr.charAt(i));
        }
        return stringBuilder.toString();
    }
}
