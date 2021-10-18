package com.wzz.leetcode.LinkList.easy;

import com.wzz.leetcode.LinkList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        List<Integer> collect = new ArrayList<>();
        while (head != null) {
            collect.add(head.val);
            head = head.next;
        }
        Collections.reverse(collect);
        int[] result = new int[collect.size()];
        for (int i = 0; i < collect.size(); i++) {
            result[i] = collect.get(i);
        }
        return result;
    }
}
