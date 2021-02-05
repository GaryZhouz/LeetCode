package com.wzz.nowcoder;

/**
 * @Date 2021/2/5 21:10
 * @created by wzz
 */
public class 反转数字 {
    /**
     * @param x int整型
     * @return int整型
     */
    public static int reverse(int x) {
        if (x % 10 == x)
            return x;
        String s = x + "";
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i > 0; i--) {
            sb.append(s.charAt(i));
        }
        return s.charAt(0) == '-' ? -Integer.parseInt(sb.toString()) : Integer.parseInt(sb.toString() + s.charAt(0));
    }

}
