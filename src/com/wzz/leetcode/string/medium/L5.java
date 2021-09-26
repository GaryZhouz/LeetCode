package com.wzz.leetcode.string.medium;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author wzz
 * @Date 2021/09/22 15:17
 */
public class L5 {

    public String longestPalindrome(String s) {
        // 暴力：超时
//        return violence(s);
        // 递归：超时
//        return decPalindrome(0, s.length() - 1, s);
        // 中心扩散
        String baseNumber = center(s, true);
        String evenNumber = center(s, false);
        return baseNumber.length() > evenNumber.length() ? baseNumber : evenNumber;

        // 滑动窗口 (可以过1000ms)
//        int size = s.length();
//        while (size > 1) {
//            for (int i = 0; i + size <= s.length(); i++) {
//                String substring = s.substring(i, i + size);
//                if (checkIsNotPalindrome(substring)) {
//                    return substring;
//                }
//            }
//            size--;
//        }
//        return s.charAt(0) + "";
    }

    private String center(String s, Boolean isNotBaseNumber) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            // 基数扩散会找不到这种情况 abba 所以让其+1
            int right = isNotBaseNumber ? i : i + 1;
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            // 出来之后前一步一定是当前的最大回文串
            String substring = s.substring(left + 1, right);
            result = substring.length() > result.length() ? substring : result;
        }
        return result;
    }

    private String violence(String target) {
        String maxStr = "";
        for (int i = 0; i < target.length(); i++) {
            for (int j = i + 1; j <= target.length(); j++) {
                String substring = target.substring(i, j);
                if (checkIsNotPalindrome(substring)) {
                    maxStr = substring.length() > maxStr.length() ? substring : maxStr;
                }
            }
        }
        return maxStr;
    }

    private String decPalindrome(int leftPointer, int rightPointer, String target) {
        if (leftPointer >= rightPointer) {
            return target.charAt(0) + "";
        }
        if (checkIsNotPalindrome(target.substring(leftPointer, rightPointer + 1))) {
            return target.substring(leftPointer, rightPointer + 1);
        }
        String s1 = decPalindrome(leftPointer, rightPointer - 1, target);
        String s2 = decPalindrome(leftPointer + 1, rightPointer, target);
        return s1.length() > s2.length() ? s1 : s2;
    }

    private boolean checkIsNotPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L5().longestPalindrome("drsrtjbbiuuhiugigiutyruyetwreezfdfxtrsreaerasrsr"));
    }
}
