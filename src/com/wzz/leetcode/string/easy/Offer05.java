package com.wzz.leetcode.string.easy;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 */
public class Offer05 {
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }
}
