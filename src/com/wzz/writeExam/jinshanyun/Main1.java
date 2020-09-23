package com.wzz.writeExam.jinshanyun;
/*
小明最喜欢的数字是5。他在班上的学号是5号，
也是学校足球队的5号队员。
现在小明希望你帮他编写一个程序，
输入一个正整数n，输出从数字1到数字n中，
一共出现了多少个5。

输入描述
单组输入。

输入一个正整数n，<n<=100000。

输出描述
输出一个整数，即1到n的数字中5出现的个数。


样例输入
50
样例输出
6

 */
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int count = 0;
        for (int i = 0; i <= x; i++) {
            count += check5(i);
        }
        System.out.println(count);
    }

    private static int check5(int i) {
        String s = String.valueOf(i);
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '5') count++;
        }
        return count;
    }
}
