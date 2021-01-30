package com.wzz.nowcoder;

import java.util.Stack;

/**
 * @Date 2021/1/30 12:39
 * @created by wzz
 */
public class 括号序列 {
    /**
     * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
     * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
     * 示例1
     * 输入
     * 复制
     * "["
     * 返回值
     * false
     * 示例2
     * 输入
     * "[]"
     * 返回值
     * true
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // 左括号入栈，遇到右括号出栈，并比对是否匹配
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
