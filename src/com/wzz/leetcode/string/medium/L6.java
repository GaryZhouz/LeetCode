package com.wzz.leetcode.string.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * @Date 2021/2/1 12:16
 * @created by wzz
 */
public class L6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        Map<Integer, List<Character>> rowCharMap = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= numRows; i++) {
            rowCharMap.put(i, new ArrayList<>());
        }
        // 标志当前row是加还是减
        boolean flag = true;
        for (int i = 0, row = 1; i < s.length(); i++) {
            List<Character> rowList = rowCharMap.get(row);
            rowList.add(s.charAt(i));
            rowCharMap.put(row, rowList);
            row = flag ? row + 1 : row - 1;
            if (row == numRows || row == 1) {
                flag = !flag;
            }
        }
        for (int i = 1; i <= numRows; i++) {
            String row = rowCharMap.get(i)
                    .stream()
                    .map(character -> character + "")
                    .collect(Collectors.joining());
            result.append(row);
        }
        return result.toString();
    }
}
