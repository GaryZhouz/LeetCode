package com.wzz.sort.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class L242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            Set<Object> save = new HashSet<>();
            Set<Object> save2 = new HashSet<>();
            HashMap<String, Integer> map = new HashMap<>();
            HashMap<String, Integer> map2 = new HashMap<>();
            getResult(s, save, map);
            getResult(t, save2, map2);

            if (save.size() != save2.size()) return false;
            Object[] a = save.toArray();
            for (int i = 0; i < a.length; i++) {
                if (!save2.contains(a[i])) return false;
                if (map.get(a[i]+"").compareTo(map2.get(a[i]+"")) == 1) return false;
            }


            return true;
        }

        private void getResult(String s, Set<Object> save, HashMap<String, Integer> map) {
            for (int i = 0; i < s.length(); i++) {
                if (!save.contains(s.charAt(i))) {//未出现过的字母
                    save.add(s.charAt(i));
                    map.put(s.charAt(i) + "", 1);
                } else {//出现过加次数即可
                    map.put(s.charAt(i) + "", map.get(s.charAt(i) + "") + 1);
                }
            }
        }

    }
}
