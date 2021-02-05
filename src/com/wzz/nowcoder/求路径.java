package com.wzz.nowcoder;

/**
 * @Date 2021/2/5 21:04
 * @created by wzz
 */
public class 求路径 {
    /**
     * 题目描述
     * 一个机器人在m×n大小的地图的左上角（起点）。
     * 机器人每次向下或向右移动。机器人要到达地图的右下角（终点）。
     * 可以有多少种不同的路径从起点走到终点？
     * <p>
     * 备注：m和n小于等于100,并保证计算结果在int范围内
     * <p>
     * 示例1
     * 输入
     * 复制
     * 2,1
     * 返回值
     * <p>
     * 1
     * 示例2
     * 输入
     * <p>
     * 2,2
     * 返回值
     * <p>
     * 2
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public int uniquePaths(int m, int n) {
        return getPath(m, n, 1, 1);
    }

    /**
     * @param m 地图宽
     * @param n 地图高
     * @param x 当前横坐标
     * @param y 当前纵坐标
     * @return
     */
    private int getPath(int m, int n, int x, int y) {
        if (x == m || y == n)
            return 1;
        return getPath(m, n, x + 1, y) + getPath(m, n, x, y + 1);
    }
}
