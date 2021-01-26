package com.wzz.nowcoder;

import java.util.List;

/**
 * @Date 2021/1/26 15:04
 * @created by wzz
 */
public class 合并有序链表 {
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
     *
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        // 用于拼接链表
        ListNode head = new ListNode(0);
        // 保存head的指针
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            // 每次选一个小的
            if (l1.val >= l2.val) {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            } else {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
        }
        // 当前有个短链表为空了 需要将另一个接上去
        if (l1 == null)
            head.next = l2;
        else
            head.next = l1;
        return temp.next;
    }
}
