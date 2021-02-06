package com.wzz.nowcoder;

/**
 * @Date 2021/2/6 10:10
 * @created by wzz
 */
public class 牛牛爱喝酒 {
    /**
     * 题目描述
     * 一瓶酒m元钱，两个酒瓶可以换一瓶酒，四个瓶盖可以换一瓶酒，现在有 n 元钱，求最多可以喝多少瓶酒？
     * （注：没有借贷功能，即最终不允许借一瓶酒、喝完后拿酒瓶兑换归还的操作）
     * 示例1
     * 输入
     * 复制
     * 2,12
     * 返回值
     * 复制
     * 19
     * 说明
     * 酒鬼总计可以喝19瓶酒
     * 备注:
     * 0 < m < 100
     * 0 < n < 2000
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回牛牛能喝的最多的酒
     *
     * @param m int整型 酒单价
     * @param n int整型 牛牛的现金
     * @return int整型
     */
    public static int countWine(int m, int n) {
        // 记录酒的数量
        int res = n / m;
        // 记录酒的瓶子数
        int bottle = res;
        // 记录瓶盖数
        int cap = bottle;
        while (bottle >= 2 || cap >= 4) {
            int i = bottle / 2 + cap / 4;
            // 多算的酒
            res += i;
            bottle = bottle % 2 + i;
            cap = cap % 4 + i;
        }
        return res;
    }

}
