package com.wzz.nowcoder;

import java.util.HashMap;

/**
 * @Date 2021/2/5 20:43
 * @created by wzz
 */
public class 数组中出现次数超过一半的数字 {
    /**
     * 题目描述
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     * 示例1
     * 输入
     * <p>
     * [1,2,3,2,2,2,5,4,2]
     * 返回值
     * 复制
     * 2
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : array) {
            map.merge(i, 1, Integer::sum);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > array.length / 2)
                return key;
        }
        return 0;
    }
}
