package com.wzz.LinkList.easy;

/*
删除链表中等于给定值 val 的所有节点。

示例:
输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 */
public class L203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode l1 = new ListNode(-1);
        ListNode l2 = l1;
        while (head != null) {
            if (head.val != val) {
                l1.next = head;
                l1 = l1.next;
            }else l1.next = null;
            head = head.next;
        }
        return l2.next;
    }
}
