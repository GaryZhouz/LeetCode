package com.wzz.leetcode.string.easy;

/**
 * @Date 2021/7/27 20:20
 * @created by wzz
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 * 说明：
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 */
public class L28 {
    public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
        if (needle.length() == 0) {
            return 0;
        }
        int needPoint = 0;
        int haystackPoint = 0;
        int temp = 0;
        int count = 0;
        while (haystackPoint < haystack.length()) {
            if (haystack.charAt(haystackPoint) == needle.charAt(needPoint)) {
                count++;
                needPoint++;
                haystackPoint++;
            } else {
                needPoint = 0;
                haystackPoint = ++temp;
                count = 0;
            }
            if (count == needle.length()) {
                return haystackPoint - needle.length();
            }
        }
        return -1;
    }
}
