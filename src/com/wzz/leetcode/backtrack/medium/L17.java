package com.wzz.leetcode.backtrack.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
class L17 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) {
            return combinations;
        }
        Map<Character, String> phoneNumberMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        StringBuilder sb = new StringBuilder();
        fullCombinations(digits, phoneNumberMap, 0, combinations, sb);
        return combinations;
    }

    public void fullCombinations(String digits, Map<Character, String> phoneNumberMap,
                                 int index, List<String> combinations, StringBuilder sb) {
        if (index == digits.length()) {
            if (!combinations.contains(sb.toString())) {
                combinations.add(sb.toString());
            }
        } else {
            String mapStr = phoneNumberMap.get(digits.charAt(index));
            for (int i = 0; i < mapStr.length(); i++) {
                sb.append(mapStr.charAt(i));
                fullCombinations(digits, phoneNumberMap, index + 1, combinations, sb);
                sb.deleteCharAt(index);
            }
        }
    }
}
