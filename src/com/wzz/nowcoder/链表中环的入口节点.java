package com.wzz.nowcoder;


/**
 * @Date 2021/1/30 11:40
 * @created by wzz
 */
public class 链表中环的入口节点 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        // 获取环的相遇节点
        ListNode meetingNode = meetingNode(head);
        if (meetingNode == null)
            return null;
        // 有环的情况,找到入环点 (相遇节点 和 头部节点 已一样的速度推进 必然会在环入口相遇!!)
        // 头节点
        ListNode slow = head;
        // 相遇节点
        ListNode fast = meetingNode;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        // 换回入环点
        return slow;
    }


    /**
     * 求环相遇的节点
     *
     * @param head
     * @return
     */
    private ListNode meetingNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            // 两倍速度
            fast = fast.next.next;
            if (slow == fast)
                return slow;
        }
        // 没有环节点
        return null;
    }
}
