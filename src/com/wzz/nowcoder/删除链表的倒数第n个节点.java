package com.wzz.nowcoder;

/**
 * @Date 2021/1/30 12:55
 * @created by wzz
 */
public class 删除链表的倒数第n个节点 {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 新增一个头方便处理头节点的删除
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode fast = root;
        ListNode slow = root;
        // 先使 fast 前进 n 步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 同时向后推,当快指针的下一个为空 则代表当前的慢指针是 倒数第n - 1个
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除 慢指针 后面的节点
        slow.next = slow.next.next;
        return root.next;
    }
}
