package com.wzz.leetcode.array.easy;

import java.util.Arrays;
import java.util.List;

/*
给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
每次「迁移」操作将会引发下述活动：
位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
请你返回 k 次迁移操作后最终得到的 二维网格。
 
示例 1：
输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
输出：[[9,1,2],[3,4,5],[6,7,8]]

示例 2：
输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]

示例 3：
输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
输出：[[1,2,3],[4,5,6],[7,8,9]]

提示：
1 <= grid.length <= 50
1 <= grid[i].length <= 50
-1000 <= grid[i][j] <= 1000
0 <= k <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shift-2d-grid
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1260 {
    public static void main(String[] args) {
        System.out.println(new L1260().shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2));
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;//行
        int n = grid[0].length;//列

        //转换为1维数组
        int[] change = new int[m * n];
        //计数
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++, count++) {
                change[count] = grid[i][j];
            }
        }

        for (int i = 0; i < k; i++) {
            handle(change, change[0]);
        }
        count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++, count++) {
                grid[i][j] = change[count];
            }
        }

        List res = Arrays.asList(grid);
        return res;
    }

    private void handle(int[] change, int x) {
        for (int i = change.length - 2; i >= 1; i--) {
            int temp = change[i];
            change[i] = change[i - 1];
            change[i - 1] = temp;
        }
        int temp = change[change.length - 1];
        change[change.length - 1] = change[0];
        change[0] = temp;
    }

}
