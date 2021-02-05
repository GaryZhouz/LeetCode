package com.wzz.nowcoder;

/**
 * @Date 2021/2/5 19:58
 * @created by wzz
 */
public class 判断回文 {
    /**
     * 题目描述
     * 给定一个字符串，请编写一个函数判断该字符串是否回文。如果回文请返回true，否则返回false。
     * <p>
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }
}
