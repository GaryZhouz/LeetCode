package com.wzz.leetcode.linkList.easy;

import com.wzz.leetcode.linkList.ListNode;

/*
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

示例：
给定一个链表: 1->2->3->4->5, 和 k = 2.
返回链表 4->5.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
//        return historyMethod(head, k);
        return newMethod(head, k);
    }

    private ListNode newMethod(ListNode head, int k) {
        ListNode slowPoint = head;
        ListNode fastPoint = head;
        for (int i = 0; i < k; i++) {
            fastPoint = fastPoint.next;
        }
        while (fastPoint != null) {
            fastPoint = fastPoint.next;
            slowPoint = slowPoint.next;
        }
        return slowPoint;
    }

    private ListNode historyMethod(ListNode head, int k) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        for (int i = 0; i < count - k; i++) {
            head = head.next;
        }
        return head;
    }
}
