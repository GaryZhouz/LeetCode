package com.wzz.leetcode.linkList.medium;

import com.wzz.leetcode.linkList.ListNode;

/**
 * @Date 2021/8/24 10:00 上午
 * @Created by zhouzhou.wang
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 */
public class L61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode lastKNode;
        ListNode lastNode = null;
        ListNode headNode = head;
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            if (temp.next == null) {
                lastNode = temp;
            }
            temp = temp.next;
        }
        final int rotate = k % length;
        if (rotate == 0) {
            return head;
        }
        for (int i = 0; i < length - rotate - 1; i++) {
            head = head.next;
        }
        lastKNode = head.next;
        head.next = null;
        lastNode.next = headNode;
        return lastKNode;
    }

}
