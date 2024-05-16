package com.wzz.leetcode.array.medium;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class Offer13 {

    public int movingCount(int m, int n, int k) {
        boolean[][] map = new boolean[m][n];
        return dfs(map, 0, 0, k);
    }

    private int dfs(boolean[][] map, int x, int y, int k) {
        if (x > map.length - 1 || y > map[0].length - 1 || map[x][y] || sum(x, y) > k) {
            return 0;
        }
        map[x][y] = true;
        return 1 + dfs(map, x + 1, y, k) + dfs(map, x, y + 1, k);
    }

    private int sum(int x, int y) {
        String s1 = x + "";
        String s2 = y + "";
        int num = 0;
        for (int i = 0; i < s1.length(); i++) {
            num += Integer.parseInt(s1.charAt(i) + "");
        }
        for (int i = 0; i < s2.length(); i++) {
            num += Integer.parseInt(s2.charAt(i) + "");
        }
        return num;
    }

    public static void main(String[] args) {
        new Offer13().movingCount(1, 2, 1);
    }
}
