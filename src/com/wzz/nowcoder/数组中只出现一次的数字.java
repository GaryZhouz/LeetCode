package com.wzz.nowcoder;

import java.util.*;

/**
 * @Date 2021/2/5 20:32
 * @created by wzz
 */
public class 数组中只出现一次的数字 {
    /**
     * 题目描述
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * <p>
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : array) {
            map.merge(i, 1, Integer::sum);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                count++;
                if (count == 1)
                    num1[0] = key;
                else if (count == 2)
                    num2[0] = key;
            }
        }
    }
}
