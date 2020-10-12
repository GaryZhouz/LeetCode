package com.wzz.writeExam.lanqiao.lq202007;

import java.util.Scanner;

/*
输入一个字符串，请输出这个字符串包含多少个大写字母，多少个小写字
母，多少个数字。
【输入格式】
输入一行包含一个字符串。
【输出格式】
输出三行，每行一个整数，分别表示大写字母、小写字母和数字的个数。
【样例输入】
1+a=Aab
【样例输出】
1 3 1
【评测用例规模与约定】
对于所有评测用例，字符串由可见字符组成，长度不超过 100。
 */
public class l_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int upperCase = 0;
        int lowerCase = 0;
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) upperCase++;
            else if (Character.isLowerCase(s.charAt(i))) lowerCase++;
            else if (Character.isDigit(s.charAt(i))) number++;
        }
        System.out.println(upperCase);
        System.out.println(lowerCase);
        System.out.println(number);
    }
}
