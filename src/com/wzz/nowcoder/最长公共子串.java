package com.wzz.nowcoder;

/**
 * @Date 2021/1/30 14:00
 * @created by wzz
 */
public class 最长公共子串 {
    /**
     * longest common substring
     * 题目描述
     * 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
     * 示例1
     * 输入
     * "1AB2345CD","12345EF"
     * 返回值
     * "2345"
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        if (str1.length()<1 || str2.length()<1) {
            return "-1";
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        int max = 0, index = 0;
        for(int i = 0; i< s1.length; i++) {
            for (int j=0;j <s2.length; j++) {
                if(s1[i] == s2[j]) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    if (max<dp[i+1][j+1]) {
                        max = dp[i+1][j+1];
                        index = i + 1;
                    }
                }
            }
        }
        if (max == 0) {
            return "-1";
        }
        return str1.substring(index - max, index);
    }
}
