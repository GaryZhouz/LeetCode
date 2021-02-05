package com.wzz.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Date 2021/2/5 19:30
 * @created by wzz
 */
public class 单链表的排序 {

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 题目描述
     * 给定一个无序单链表，实现单链表的排序(按升序排序)。
     * 示例1
     * 输入
     * [1,3,2,4,5]
     * 返回值
     * {1,2,3,4,5}
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        // 存放链表的所有节点值
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        // 排序
        Collections.sort(values);
        // 结果
        ListNode res = new ListNode(-1);
        // 指向结果的指针
        ListNode help = res;
        // 生成链表
        for (Integer value : values) {
            help.next = new ListNode(value);
            help = help.next;
        }
        return res.next;
    }
}
