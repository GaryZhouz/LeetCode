package com.wzz.writeExam.duxiaoman;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
    输入当前人有的油漆数量 为AAB 则表示A有2桶 B有一桶

    输入需要使用的油漆数量 为BB 则表示需要2桶B

    则输出2     (输入均为大写字母的字符串)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentHaveColor = scanner.nextLine();
        String targetUseColor = scanner.nextLine();
        int count = 0;

        Map<Character, Long> haveColor = new HashMap<>();

        for (int i = 0; i < currentHaveColor.length(); i++) {
            if (haveColor.get(currentHaveColor.charAt(i)) != null)
                haveColor.put(currentHaveColor.charAt(i), haveColor.get(currentHaveColor.charAt(i)) + 1L);
            else haveColor.put(currentHaveColor.charAt(i), 1L);
        }

        for (int i = 0; i < targetUseColor.length(); i++) {
            if (haveColor.get(targetUseColor.charAt(i)) != null && haveColor.get(targetUseColor.charAt(i)) >= 1L) {
                count++;
                haveColor.put(targetUseColor.charAt(i), haveColor.get(targetUseColor.charAt(i)) - 1);
            }
        }
        System.out.println(count);
    }
}
