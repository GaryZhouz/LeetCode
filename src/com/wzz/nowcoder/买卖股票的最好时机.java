package com.wzz.nowcoder;

/**
 * @Date 2021/2/5 20:08
 * @created by wzz
 */
public class 买卖股票的最好时机 {
    /**
     * 题目描述
     * 假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。
     * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
     * 示例1
     * 输入
     * [1,4,2]
     * 返回值
     * 3
     * 示例2
     * 输入
     * 复制
     * [2,4,1]
     * 返回值
     * 2
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        // 定义最小的值
        int min = prices[0];
        // 定义最大的值
        int max = -1;

        for (int i = 0; i < prices.length; ++i) {
            if (min > prices[i])// 保存当前最小的值
                min = prices[i];
            if (max < prices[i] - min) // 保存当前最大的利润
                max = prices[i] - min;
        }
        return max;
    }
}
