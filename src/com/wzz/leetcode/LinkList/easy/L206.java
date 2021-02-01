package com.wzz.leetcode.LinkList.easy;

import com.wzz.leetcode.LinkList.ListNode;

/*
反转一个单链表。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class L206 {
    public ListNode reverseList(ListNode head) {
        //保存上一个节点
        ListNode prev = null;
        //当前连标的节点
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }
}
