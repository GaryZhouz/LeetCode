package com.wzz.nowcoder;

/**
 * @Date 2021/2/1 10:56
 * @created by wzz
 */
public class 两个链表的第一个公共节点 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = getListNodeLength(pHead1);
        int len2 = getListNodeLength(pHead2);
        // 长链表先走差值步数
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                pHead1 = pHead1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                pHead2 = pHead2.next;
            }
        }

        while (pHead1 != null) {
            if (pHead1 == pHead2)
                return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    private int getListNodeLength(ListNode node) {
        int count = 0;
        ListNode temp = node;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
