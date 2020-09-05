package com.wzz.sort.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * <p>
 * 示例 2：
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 * 示例 3：
 * <p>
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 * 示例 4：
 * <p>
 * 输入：s = "ggggggg"
 * 输出："ggggggg"
 * 示例 5：
 * <p>
 * 输入：s = "spo"
 * 输出："ops"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1370 {
    
    public String sortString(String s) {
        Map<String, Integer> map = new HashMap<>();//存放字符的数字A 65编号
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i) + "") == null) {
                map.put(s.charAt(i) + "", 1);
            } else {
                map.put(s.charAt(i) + "", map.get(s.charAt(i) + "") + 1);
            }
        }
        while (sb.length() != s.length()) {//当所有字母都用到且放入了目标串中
            for (int i = 0; i < 26; i++) {//找最小字母
                if (sb.length() == s.length()) break;
                if (map.get((char) (i + (int) 'a') + "") != null && map.get((char) (i + (int) 'a') + "") != 0) {//有对应当前的最小字母

                    map.put((char) (i + (int) 'a') + "", map.get((char) (i + (int) 'a') + "") - 1);
                    sb.append((char) (i + (int) 'a'));
                }
            }

            for (int i = 25; i >= 0; i--) {//找最大字母
                if (sb.length() == s.length()) break;
                if (map.get((char) (i + (int) 'a') + "") != null && map.get((char) (i + (int) 'a') + "") != 0) {//有对应当前的最大字母
                    map.put((char) (i + (int) 'a') + "", map.get((char) (i + (int) 'a') + "") - 1);
                    sb.append((char) (i + (int) 'a'));
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        L1370 l1370 = new L1370();
        String s1 = l1370.sortString("aaaabbbbcccc");
        System.out.println(s1);
    }
}
