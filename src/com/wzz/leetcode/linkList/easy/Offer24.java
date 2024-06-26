package com.wzz.leetcode.linkList.easy;

import com.wzz.leetcode.linkList.ListNode;

/*
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

限制：
0 <= 节点个数 <= 5000
 */
public class Offer24 {
    public ListNode reverseList(ListNode head) {
        //保存上一个节点
        ListNode prev = null;
        //当前连标的节点
        ListNode cur = head;
        // 反向改造一条链表，头插
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }
}
