package com.wzz.leetcode.linkList.medium;

import com.wzz.leetcode.linkList.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 */
public class L92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = head, temp = new ListNode(-1), tempLastNode = temp, needReverseStartNodePrev = new ListNode(-1);
        int index = 1;
        while (index <= right && head != null) {
            if (index == left - 1) {
                needReverseStartNodePrev = head;
            }
            if (index >= left) {
                ListNode virtualNode = new ListNode(head.val);
                if (index == left) {
                    tempLastNode = virtualNode;
                }
                if (temp.next != null) {
                    virtualNode.next = temp.next;
                }
                temp.next = virtualNode;
            }
            index++;
            head = head.next;
        }
        // 翻转后的最后一个节点就是head 直接link起来
        tempLastNode.next = head;
        // 翻转前的最后一个节点 直接link起来(如果没有的情况 不能直接返回res 因为新生成的链表没有连接到head上
        if (needReverseStartNodePrev.val == -1) {
            return temp.next;
        }
        needReverseStartNodePrev.next = temp.next;
        return res;
    }
}
