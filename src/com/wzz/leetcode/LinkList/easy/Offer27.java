package com.wzz.leetcode.LinkList.easy;

import com.wzz.leetcode.LinkList.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * <p>
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2]
 * 输出: false
 *  
 * <p>
 * 提示：
 * <p>
 * 链表 L 的长度范围为 [1, 105]
 * 0 <= node.val <= 9
 *  
 * <p>
 * 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Offer27 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        String str = stringBuilder.toString();
        for (int i = 0; i < str.length() / 2 + 1; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
