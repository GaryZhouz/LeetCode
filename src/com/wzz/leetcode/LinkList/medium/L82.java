package com.wzz.leetcode.LinkList.medium;

import com.wzz.leetcode.LinkList.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date 2021/8/24 10:43 上午
 * @Created by zhouzhou.wang
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 */
public class L82 {

    /**
     * 两趟
     *
     * @param head
     * @return
     */
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        final Map<Integer, Integer> elementsCountMap = new HashMap<>();
//        ListNode temp = head;
//        ListNode result = head;
//        ListNode prevListNode = head;
//        while (temp != null) {
//            if (elementsCountMap.containsKey(temp.val)) {
//                elementsCountMap.put(temp.val, elementsCountMap.get(temp.val) + 1);
//            } else {
//                elementsCountMap.put(temp.val, 1);
//            }
//            temp = temp.next;
//        }
//        while (head != null) {
//            if (elementsCountMap.containsKey(head.val) && elementsCountMap.get(head.val) > 1) {
//                prevListNode.next = head.next;
//                head = head.next;
//                continue;
//            }
//            prevListNode = head;
//            head = head.next;
//        }
//        return elementsCountMap.containsKey(result.val) && elementsCountMap.get(result.val) > 1 ? result.next : result;
//    }

    // 一趟
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prevPoint = new ListNode(Integer.MAX_VALUE, head);
        ListNode result = prevPoint;
        ListNode nextPoint = head;
        final List<Integer> elements = new ArrayList<>();
        while (nextPoint.next != null) {
            if (nextPoint.val == nextPoint.next.val || elements.contains(nextPoint.val)) {
                elements.add(nextPoint.val);
            } else {
                prevPoint.next = nextPoint;
                prevPoint = prevPoint.next;
            }
            nextPoint = nextPoint.next;
        }
        prevPoint.next = elements.contains(nextPoint.val) ? null : nextPoint;
        return result.next;
    }
}
