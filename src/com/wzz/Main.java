package com.wzz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Date 2020/11/29 19:13
 * @created by wzz
 */
public class Main {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode rev(ListNode target) {
        List<ListNode> nodes = new ArrayList<>();
        while (target != null) {
            nodes.add(new ListNode(target.val));
            target = target.next;
        }
        Collections.reverse(nodes);
        ListNode resNode = new ListNode(-1);
        ListNode temp = resNode;
        for (ListNode node : nodes) {
            resNode.next = node;
            resNode = resNode.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode rev = rev(listNode1);
        while (rev != null){
            System.out.println(rev.val);
            rev = rev.next;
        }
    }
}
