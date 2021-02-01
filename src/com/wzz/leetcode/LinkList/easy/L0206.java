package com.wzz.leetcode.LinkList.easy;

import com.wzz.leetcode.LinkList.ListNode;

/*
编写一个函数，检查输入的链表是否是回文的。


示例 1：
输入： 1->2
输出： false

示例 2：
输入： 1->2->2->1
输出： true

进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L0206 {
    public boolean isPalindrome(ListNode head) {
        //存储最开始的链表的内存地址
        ListNode h = head;
        //存储反转后的链表
        ListNode node = null;
        while (head != null) {//反转链表
            ListNode n = new ListNode(head.val); //复制
            n.next = node;
            node = n;
            head = head.next;
        }
        //判断是否为回文链表
        while (h != null) {
            if (h.val != node.val) return false;
            h = h.next;
            node = node.next;
        }
        return true;
    }
}
