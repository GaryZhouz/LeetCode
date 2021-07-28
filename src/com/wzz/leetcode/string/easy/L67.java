package com.wzz.leetcode.string.easy;

/**
 * @Date 2021/7/28 3:35 下午
 * @Created by zhouzhou.wang
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class L67 {
    public String addBinary(String a, String b) {
        int leftPoint = a.length() - 1, rightPoint = b.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        // 是否存在进位
        int temp = 0;
        while (leftPoint >= 0 && rightPoint >= 0) {
            int left = a.charAt(leftPoint) - '0';
            int right = b.charAt(rightPoint) - '0';
            if (left + right + temp >= 2) {
                stringBuilder.append((left + right + temp) % 2);
                temp = 1;
            } else {
                stringBuilder.append(left + right + temp);
                temp = 0;
            }
            leftPoint--;
            rightPoint--;
        }
        if (leftPoint >= 0) {
            temp = letLongStringContinue(a, leftPoint, stringBuilder, temp);
        }
        if (rightPoint >= 0) {
            temp = letLongStringContinue(b, rightPoint, stringBuilder, temp);
        }
        if (temp == 1) {
            stringBuilder.append(temp);
        }
        return stringBuilder.reverse().toString();
    }

    private int letLongStringContinue(String a, int point, StringBuilder stringBuilder, int temp) {
        while (point >= 0) {
            int cur = a.charAt(point) - '0';
            if (cur + temp >= 2) {
                stringBuilder.append((cur + temp) % 2);
                temp = 1;
            } else {
                stringBuilder.append(cur + temp);
                temp = 0;
            }
            point--;
        }
        return temp;
    }
}