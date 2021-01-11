package com.wzz.other.tw_plane_problem.w;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Date 2021/1/7 10:34
 * @created by wzz
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] map = new int[x][y];
//        solution1(map, 0, map[0].length - 1, 0, map.length - 1);
        solution2(map);
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

    private static void solution1(int[][] map, int left, int right, int up, int down) {
        // 记录飞行次数
        int count = 0;
        while (true) {
            // 从左到右飞行
            for (int i = left; i <= right; i++) {
                takePhoto(map, up, i, count++);
            }
            if (++up > down) break;
            // 从上到下飞行
            for (int i = up; i <= down; i++) {
                takePhoto(map, i, right, count++);
            }
            if (--right < left) break;
            // 从右到左
            for (int i = right; i >= left; i--) {
                takePhoto(map, down, i, count++);
            }
            if (--down < up) break;
            //从下到上
            for (int i = down; i >= up; i--) {
                takePhoto(map, i, left, count++);
            }
            if (++left > right) break;
        }
    }

    private static void takePhoto(int[][] map, int row, int col, int count) {
        if (count % 3 == 0) {// 当前飞行是三次的倍数
            map[row][col] = 1;
        }
    }

    private static void solution2(int[][] map) {
        int row = map.length;
        if (row == 1) {
            setValue(map, 0);
        }
        for (int i = 1; i < row; i += 2) {
            setValue(map, i);
        }
    }

    private static void setValue(int[][] map, int row) {
        if (map[row].length < 2) {
            Arrays.fill(map[row], 1);
            return;
        }
        for (int i = 0; i < map[row].length; i += 3) {
            map[row][i] = 1;
        }
        if (map[row][map[row].length - 2] != 1)
            map[row][map[row].length - 1] = 1;
    }

}
