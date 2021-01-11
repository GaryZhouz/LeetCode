package com.wzz.other.tw_plane_problem;

import java.util.Scanner;

/**
 * @Date 2021/1/7 10:11
 * @created by wzz
 *
 * 问题描述：
 * 一个字符型二维矩阵中，每个格子都代表一个地理位置信息，需要设计一个无人机的飞行路线，拍下地图全景，
 * 每次可以拍上下左右中五个位置的照片。
 * 主要思路：
 * 1 螺旋飞行+3格定时拍照，每三个格子拍照一次，可以保证拍下全图。足够大的情况下，拍照次数约为全图1/3
 * 2 隔行跳跃飞行，可以保证拍下全图。足够大的情况下，飞行距离约为全图1/3
 */
public class Plane {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int col = input.nextInt();
        // 创建地图
        int[][] map = createMap(row, col);
        // 螺旋飞行
//        new SolutionOne().spiralTravel(map, 0, map[0].length - 1, 0, map.length - 1);
        // 跳跃飞行
        new SolutionTwo().skipTravel(map, 0, map[0].length - 1, 1, map.length - 1);
        // 打印结果
        printMap(map);
    }

    private static int[][] createMap(int row, int col) {
        return new int[row][col];
    }

    private static void printMap(int[][] map) {
        for (int[] info : map) {
            for (int val : info) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
