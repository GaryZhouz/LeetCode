package com.wzz.nowcoder;

/**
 * @Date 2021/1/30 14:42
 * @created by wzz
 */
public class 两个链表生成相加链表 {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // 存储反转的链表
        ListNode reverseHead1 = null;
        ListNode reverseHead2 = null;
        ListNode help = new ListNode(-1);
        // 结果的反转
        ListNode reverseRes = help;
        ListNode res = null;
        // 反转
        while (head1 != null) {
            ListNode temp = head1.next;
            head1.next = reverseHead1;
            reverseHead1 = head1;
            head1 = temp;
        }
        while (head2 != null) {
            ListNode temp = head2.next;
            head2.next = reverseHead2;
            reverseHead2 = head2;
            head2 = temp;
        }
        // 记录是否有进位的1
        boolean flag = false;
        while (reverseHead1 != null || reverseHead2 != null) {
            if (reverseHead1 == null)
                reverseHead1 = new ListNode(0);
            if (reverseHead2 == null)
                reverseHead2 = new ListNode(0);

            int val = reverseHead1.val + reverseHead2.val;
            if (flag) {
                val++;
                flag = false;
            }

            if (val >= 10) {
                val -= 10;
                flag = true;
            }
            help.next = new ListNode(val);
            help = help.next;
            reverseHead1 = reverseHead1.next;
            reverseHead2 = reverseHead2.next;
        }
        // 当两个反转的链表都为空的时候,最后一个值是大于10的 需要多接上一个 1 的节点
        if (flag)
            help.next = new ListNode(1);
        // 最后反转即可
        reverseRes = reverseRes.next;
        while (reverseRes != null) {
            ListNode temp = reverseRes.next;
            reverseRes.next = res;
            res = reverseRes;
            reverseRes = temp;
        }
        return res;
    }
}
