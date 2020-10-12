package com.wzz.writeExam.lanqiao.lq202007;

import java.util.Arrays;
import java.util.List;

/*
9090400
8499400
5926800
8547000
4958200
4422600
5751200
4175600
6309600
5865200
6604400
4635000
10663400
8087200
4554000
 */
public class l_04 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(9090400, 8499400, 5926800, 8547000, 4958200, 4422600, 5751200, 4175600, 6309600, 5865200, 6604400, 4635000, 10663400, 8087200, 4554000);
        int h1 = 0;
        int h2 = 0;
        Integer[] i = integers.toArray(new Integer[integers.size()]);
        Arrays.sort(i);
        for (int j = 0; j < i.length; j++) {
            if (j % 2 == 0) h1 += i[j];
            else h2 += i[j];
        }
        System.out.println(h1);
        System.out.println(h2);
    }
}
