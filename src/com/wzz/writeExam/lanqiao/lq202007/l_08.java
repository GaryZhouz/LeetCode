package com.wzz.writeExam.lanqiao.lq202007;

import java.util.HashMap;
import java.util.Scanner;

/*
小明发明了一种给由全大写字母组成的字符串编码的方法。对于每一个大
写字母，小明将它转换成它在 26 个英文字母中序号，即 A ! 1, B ! 2, ... Z !
26。
这样一个字符串就能被转化成一个数字序列：
比如 ABCXYZ ! 123242526。
现在给定一个转换后的数字序列，小明想还原出原本的字符串。当然这样
的还原有可能存在多个符合条件的字符串。小明希望找出其中字典序最大的字
符串。
【输入格式】
一个数字序列。
【输出格式】
一个只包含大写字母的字符串，代表答案
【样例输入】
123242526
【样例输出】
LCXYZ
【评测用例规模与约定】
对于 20% 的评测用例，输入的长度不超过 20。
对于所有评测用例，输入的长度不超过 200000。
 */
public class l_08 {

    public static int getInt(int x, int y) {
        return Integer.parseInt(x + "" + y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String i = scanner.next();
        int[] x = new int[i.length()];

        HashMap<Integer, Character> map = new HashMap<>();
        for (int j = 1; j <= 26; j++) {
            map.put(j,(char) (65 + j -1));
        }

        for (int j = 0; j < i.length(); j++) {
            x[j] = Integer.parseInt(i.charAt(j) + "");
        }
        for (int j = 0; j < x.length - 1; j++) {
            if (getInt(x[j], x[j + 1]) <= 26){
                System.out.print(map.get(getInt(x[j], x[j + 1])));
                j++;
            }else System.out.print(map.get(x[j]));
        }
    }
}
