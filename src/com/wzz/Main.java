package com.wzz;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Date 2020/11/29 19:13
 * @created by wzz
 * 1000万无序号数组,找出最大的十项
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000_0000; i++) {
            list.add(new Random().nextInt(10000));
        }
        System.out.println(new Main().top10(list));
    }

    public ArrayList<Integer> top10(List<Integer> input) {
        Collections.sort(input);
        Collections.reverse(input);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            res.add(input.get(i));
        }
        Collections.reverse(res);
        return res;
    }
}
