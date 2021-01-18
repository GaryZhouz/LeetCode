package com.wzz.string.easy;

/**
 * @Date 2020/11/22 19:19
 * @created by wzz
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 * <p>
 * 注意：你 不能 修改非 '?' 字符。
 * <p>
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 * <p>
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "?zs"
 * 输出："azs"
 * 解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两个 'z' 。
 * 示例 2：
 * <p>
 * 输入：s = "ubv?w"
 * 输出："ubvaw"
 * 解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
 * 示例 3：
 * <p>
 * 输入：s = "j?qg??b"
 * 输出："jaqgacb"
 * 示例 4：
 * <p>
 * 输入：s = "??yw?ipkj?"
 * 输出："acywaipkja"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * <p>
 * s 仅包含小写英文字母和 '?' 字符
 */
public class L1576 {
    public String modifyString(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                if (i == 0) {
                    if (s.length() == 1) return "a";
                    for (int j = 0; j < 26; j++) {
                        if (s.charAt(i + 1) != (char) j + 97) {
                            sb.append((char) (j + 97));
                            break;
                        }
                    }
                } else if (i == s.length() - 1) {
                    for (int j = 0; j < 26; j++) {
                        if (sb.toString().charAt(i - 1) != (char) j + 97) {
                            sb.append((char) (j + 97));
                            break;
                        }
                    }
                } else {
                    for (int j = 0; j < 26; j++) {
                        if (sb.toString().charAt(i - 1) != (char) j + 97 && s.charAt(i + 1) != (char) j + 97) {
                            sb.append((char) (j + 97));
                            break;
                        }
                    }
                }

            } else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}