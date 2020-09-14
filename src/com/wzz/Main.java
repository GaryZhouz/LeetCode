package com.wzz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("==========九九乘法表==========");

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + " ");
            }
            System.out.println();
        }

        System.out.println("==========直角三角形==========");

        Scanner scanner = new Scanner(System.in);
//        System.out.print("请输入行数: ");
//        int row = scanner.nextInt();
        int row = 5;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < row - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("==========等腰三角形==========");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("==========空心等腰三角形==========");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("==========菱形==========");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
        for (int i = row; i >= 0; i--) {
            for (int j = row - i - 1; j >= 0; j--) {
                System.out.print(" ");
            }
            for (int j = i; j >= 0; j--) {
                if (j == 0 || j == i) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("请输入年份");
        int year = scanner.nextInt();
        System.out.println("当前年份:" + year);
        for (int i = 1; i <= 12; i++) {
            System.out.print(i + "月 ");
        }
        System.out.println();
        System.out.println("请输入当前月份:");
        String month = scanner.next();
        switch (month) {
            case "1":
                System.out.println("当前月有31天");
                System.out.println("日 一 二 三 四 五 六");
                checkDay(year, Integer.parseInt(month), 1);
                break;
            case "2":
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    System.out.println("当前月有29天");
                    checkDay(year, Integer.parseInt(month), 1);
                    break;
                }
                System.out.println("当前月28天");
                break;
            case "3":
                System.out.println("当前月有31天");
                break;
            case "4":
                System.out.println("当前月有30天");
                break;
            case "5":
                System.out.println("当前月有31天");
                break;
            case "6":
                System.out.println("当前月有30天");
                break;
            case "7":
                System.out.println("当前月有31天");
                break;
            case "8":
                System.out.println("当前月有31天");
                break;
            case "9":
                System.out.println("当前月有30天");
                break;
            case "10":
                System.out.println("当前月有31天");
                break;
            case "11":
                System.out.println("当前月有30天");
                break;
            case "12":
                System.out.println("当前月有31天");
                break;
        }
    }

    private static void checkDay(int year, int month, int day) {//检查是星期几

        int w = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
        System.out.println(w);
        System.out.println("星期" + w % 7);
    }
}
