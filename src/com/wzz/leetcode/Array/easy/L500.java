package com.wzz.leetcode.Array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/7/16 12:45 下午
 * @Created by zhouzhou.wang
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * <p>
 * 美式键盘 中：
 * <p>
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * 示例 2：
 * <p>
 * 输入：words = ["omk"]
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 */
public class L500 {

    public String[] findWords(String[] words) {
        List<String> keymap = new ArrayList<>();
        keymap.add("qwertyuiopQWERTYUIOP");
        keymap.add("asdfghjklASDFGHJKL");
        keymap.add("zxcvbnmZXCVBNM");
        List<String> result = new ArrayList<>();
        for (String word : words) {
            for (String s : keymap) {
                boolean flag = true;
                for (int w = 0; w < word.length(); w++) {
                    if (!s.contains(word.charAt(w) + "")) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    result.add(word);
                }
            }
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        new L500().findWords(new String[]{"Hello","Alaska","Dad","Peace"});
    }

}
