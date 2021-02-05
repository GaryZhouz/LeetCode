package com.wzz.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Date 2021/2/5 20:41
 * @created by wzz
 */
public class 判断一个链表是否为回文结构 {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < values.size() / 2; i++) {
            if (!Objects.equals(values.get(i), values.get(values.size() - 1 - i)))
                return false;
        }
        return true;
    }
}
