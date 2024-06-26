package com.wzz.leetcode.array.easy;

import java.util.HashMap;

/*
给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
返回词汇表 words 中你掌握的所有单词的 长度之和。

示例 1:
输入：words = ["cat","bt","hat","tree"], chars = "atach"
输出：6
解释：
可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6

示例 2：
输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
输出：10
解释：
可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。

提示：
1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
所有字符串中都仅包含小写英文字母

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1160 {
    public static void main(String[] args) {
        new L1160().countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach");
    }

    public int countCharacters(String[] words, String chars) {
        //存放chars字母出现次数
        HashMap<String, Integer> map = new HashMap<>();
        //计数
        int count = 0;
        //放入map
        for (int i = 0; i < chars.length(); i++) {
            if (map.get(chars.charAt(i) + "") != null) map.put(chars.charAt(i) + "", map.get(chars.charAt(i) + "") + 1);
            else map.put(chars.charAt(i) + "", 1);
        }
        //每个单词遍历
        for (int i = 0; i < words.length; i++) {
            count += checkIsCreated(words[i], map);
        }
        return count;
    }

    private int checkIsCreated(String word, HashMap<String, Integer> map) {
        //拷贝
        HashMap<String, Integer> copy = new HashMap<>();
        copy.putAll(map);

        for (int i = 0; i < word.length(); i++) {
            if (copy.get(word.charAt(i) + "") != null) {
                copy.put(word.charAt(i) + "", copy.get(word.charAt(i) + "") - 1);
                if (copy.get(word.charAt(i) + "") < 0) return 0;
            } else return 0;
        }
        return word.length();
    }
}
