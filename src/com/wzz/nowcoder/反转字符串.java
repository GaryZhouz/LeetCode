package com.wzz.nowcoder;

/**
 * @Date 2021/2/1 10:54
 * @created by wzz
 */
public class 反转字符串 {
    /**
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public String solve (String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
