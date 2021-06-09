package com.wzz;

/**
 * @Date 2021/4/27 12:51
 * @created by wzz
 */

import java.util.Scanner;

public class Bowling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] scores = new int[12][4];
        // 录入分数
        scannerScores(sc, scores);
        // 计算分数
        for (int i = 0; i < scores.length - 2; i++) {
            if (scores[i][0] == 10) {// 当前轮次的第一次就是十分
                if (scores[i + 1][0] == 10) { // 前8轮，一次10分 就记后面2投球的分数
                    scores[i][2] = scores[i][0] + scores[i + 1][0] + scores[i + 2][0];
                } else if (scores[i + 1][0] != 10) {// 第9轮10分 记第10轮2次的分数
                    scores[i][2] = scores[i][0] + scores[i + 1][0] + scores[i + 1][1];
                }
            } else {
                if (scores[i][0] + scores[i][1] == 10) {// 前9轮 补中10分 加上下轮第一次的分数
                    scores[i][2] = scores[i][0] + scores[i][1] + scores[i + 1][0];
                } else {
                    scores[i][2] = scores[i][0] + scores[i][1];// 2次不足10分 就记这么多
                }
            }
        }

        //求累计积分
        scores[0][3] = scores[0][2];
        for (int i = 1; i < scores.length; i++) {
            scores[i][3] = scores[i][2] + scores[i - 1][3];
        }
        //打印所有
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(scores[i][j] + "\t");
            }
            System.out.println("\t第" + (i + 1) + "轮\n");
        }
    }

    private static void scannerScores(Scanner sc, int[][] scores) {
        for (int i = 0; i < scores.length; i++) {
                System.out.printf("请输入第%d轮,第一次的得分:", i + 1);
                scores[i][0] = sc.nextInt();
                if (scores[i][0] < 10) {// 当前第一次得分为10
                    System.out.printf("请输入第%d轮,第二次的得分:", i + 1);
                    scores[i][1] = sc.nextInt();
                }
        }
    }
}
