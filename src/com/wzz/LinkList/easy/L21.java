package com.wzz.LinkList.easy;

/*
 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class L21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resNode = new ListNode(-1);
        ListNode help = resNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {//对其值精心判断
                help.next = l1;
                l1 = l1.next;
            } else {
                help.next = l2;
                l2 = l2.next;
            }
            //节点指向 自己的下一个 (因为走完上诉流程 自己当前节点已经有内容了,然后需要将指向变成下一个的指向)
            help = help.next;
        }
        //当前走完的时候, 有一个节点变成了null 需要将值指向那个非空的节点
        help.next = l1 == null ? l2 : l1;
        return resNode.next;
    }
}
