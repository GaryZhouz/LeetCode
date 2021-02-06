package com.wzz.nowcoder;

/**
 * @Date 2021/2/6 11:02
 * @created by wzz
 */
public class 牛牛和二进制 {
    /**
     * 题目描述
     * 牛牛想把一个数n转化为八位的二进制数，只不过牛牛不知道该怎么做，所以他想请你帮忙。
     * 给定一个数n，返回将这个数转化为八位的二进制数(不足八位，往前补0)。
     * 示例1
     * 输入
     * 复制
     * 1
     * 返回值
     * 复制
     * "00000001"
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 给定一个数n，返回将这个数转化为八位的二进制数(不足八位，往前补0)。
     *
     * @param n int整型 代表题目中的n
     * @return string字符串
     */
    public String tranBinary(int n) {
        StringBuilder res = new StringBuilder(Integer.toString(n, 2));
        while (res.length() != 8) {
            res.insert(0, "0");
        }
        return res.toString();
    }
}
