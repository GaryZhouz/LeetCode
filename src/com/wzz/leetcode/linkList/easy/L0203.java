package com.wzz.leetcode.linkList.easy;

import com.wzz.leetcode.linkList.ListNode;

/*
实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。

示例：
输入：单向链表a->b->c->d->e->f中的节点c
结果：不返回任何数据，但该链表变为a->b->d->e->f
 */
public class L0203 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;//将当前节点的值改为下一个节点的值
        node.next = node.next.next;
    }
}
