package com.wzz.nowcoder;

/**
 * @Date 2021/2/5 20:46
 * @created by wzz
 */
public class 链表中倒数第k个节点 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode FindKthToTail(ListNode head, int k) {
            if (head == null)
                return null;
            while (!isNumberKNode(head, k) && head != null) {
                head = head.next;
            }
            return head;
        }

        /**
         * 判断是否倒数的第k个节点
         *
         * @param head
         * @param k
         * @return
         */
        private boolean isNumberKNode(ListNode head, int k) {
            ListNode temp = head;
            // 记录当前链表几个节点后为空
            int count = 0;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count == k;
        }

    }
}
