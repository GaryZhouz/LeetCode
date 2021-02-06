package com.wzz.nowcoder;

/**
 * @Date 2021/2/6 10:32
 * @created by wzz
 */
public class 好数 {
    /**
     * 题目描述
     * 若一个数的首位和末位相等，则定义这个数为“好数”。
     * 例如：1231、4512394是好数，而12345、768740则不是好数。
     * 请你编写一个函数，判断是不是好数。如果是好数则返回true，否则返回false。
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 判断x是不是好数
     *
     * @param x int整型 待判断的数
     * @return bool布尔型
     */
    public boolean judge(int x) {
        // 末位
        int last = x % 10;
        double temp = x;
        while (temp >= 1) {
            temp /= 10;
        }
        // 首位
        int start = (int) (temp * 10);
        return start == last;
    }
}
