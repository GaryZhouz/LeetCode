package com.wzz;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().drink(new int[]{1, 1, 2, 3, 4}, 5, 2));
    }

    /*
    [3, 2, 0, 3, 4],5,2
    0
    2 - 2  -0  -1
     */
    public int drink(int[] s, int x, int y) {
        if (x == y) {
            for (int i = 0; i < s.length; i++) {
                if (s[i] == y) return i;
            }
        }
        int min_temp = x / y;
        if (x % y != 0) min_temp++;
        int temp = Integer.MAX_VALUE;
        for (int j = 0; j < s.length; j++) {
            for (int i = 0; i < s.length - min_temp; i++) {
                int i1 = handle(s, i, i + min_temp, x, y);
                temp = Math.min(i1, temp);
            }
            if (temp == Integer.MAX_VALUE) min_temp++;
            else break;
        }

        return temp;
    }

    /**
     * @param s        目标数组
     * @param i        当前位置开始
     * @param min_temp 默认最少需要的步数
     * @param x        需要喝水量
     * @param y        嘴长
     * @return
     */
    private int handle(int[] s, int i, int min_temp, int x, int y) {
        int curDrink = 0;
        for (int j = i; j <= min_temp; j++) {
            if (curDrink >= x) {
                curDrink = 0;
                return i;
            }
            if (s[j] >= y) {
                curDrink += y;
            } else {
                curDrink += s[j];
            }
        }
        if (curDrink >= x) return i;
        return Integer.MAX_VALUE;
    }
}
