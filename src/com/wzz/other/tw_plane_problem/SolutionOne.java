package com.wzz.other.tw_plane_problem;

/**
 * @Date 2021/1/7 10:11
 * @created by wzz
 */
public class SolutionOne {

    public void spiralTravel(int[][] map, int left, int right, int up, int down) {
        int count = 0;
        while (true) {
            // 左到右
            for (int col = left; col <= right; col++) {
                takePhoto(map, up, col, count++);
            }
            if (++up > down) break;
            // 上到下
            for (int row = up; row <= down; row++) {
                takePhoto(map, row, right, count++);
            }
            if (--right < left) break;
            // 右到左
            for (int col = right; col >= left; col--) {
                takePhoto(map, down, col, count++);
            }
            if (--down < up) break;
            // 下到上
            for (int row = down; row >= up; row--) {
                takePhoto(map, row, left, count++);
            }
            if (++left > right) break;
        }
    }

    private void takePhoto(int[][] map, int row, int col, int count) {
        if (count % 3 == 0) {
            map[row][col] = 1;
        }
    }
}
