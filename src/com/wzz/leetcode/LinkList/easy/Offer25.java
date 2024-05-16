package com.wzz.leetcode.LinkList.easy;

import com.wzz.leetcode.LinkList.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 * <p>
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(-1);
        ListNode result = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newNode.next = new ListNode(l1.val);
                newNode = newNode.next;
                l1 = l1.next;
            } else {
                newNode.next = new ListNode(l2.val);
                newNode = newNode.next;
                l2 = l2.next;
            }
        }
        newNode.next = l1 != null ? l1 : l2;
        return result.next;
    }
}
