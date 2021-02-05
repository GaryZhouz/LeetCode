package com.wzz.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Date 2021/2/1 15:04
 * @created by wzz
 */
public class 合并k个已排序的链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        List<Integer> nums = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null){
                nums.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(nums);
        ListNode node = new ListNode(-1);
        ListNode res = node;
        for (Integer num : nums) {
            node.next = new ListNode(num);
            node = node.next;
        }
        return res.next;
    }
}
