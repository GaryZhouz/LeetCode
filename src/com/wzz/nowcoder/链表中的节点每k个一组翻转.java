package com.wzz.nowcoder;

/**
 * @Date 2021/1/26 18:13
 * @created by wzz
 */
public class 链表中的节点每k个一组翻转 {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 题目描述
     * 将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
     * 如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
     * 你不能更改节点中的值，只能更改节点本身。
     * 要求空间复杂度 \ O(1) O(1)
     * 例如：
     * 给定的链表是1\to2\to3\to4\to51→2→3→4→5
     * 对于 \ k = 2 k=2, 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
     * 对于 \ k = 3 k=3, 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5
     * <p>
     * 示例1
     * 输入
     * <p>
     * {1,2,3,4,5},2
     * 返回值
     * <p>
     * {2,1,4,3,5}
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        ListNode node = null;
        ListNode res = new ListNode(-1);
        // 指向res节点根的指针
        ListNode start_node = res;
        // 两个帮助记录节点信息的 链表指针
        ListNode temp = head; // 每一组的节点  小于等于k个一组
        ListNode temp2;
        // 节点计数
        int count = 0;
        while (head != null) {
            if (count != k) {// 节点达不到k个 节点不变
                if (count == 0)
                    temp = head;
                head = head.next;
                count++;
            }
            if (count == k) {// 当前节点需要 头插法 反转
                for (int i = 0; i < k; i++) {
                    // 头插法
                    temp2 = temp.next;
                    temp.next = node;
                    node = temp;
                    temp = temp2;
                }
                // 结果节点 指向 当前 反转的链表
                res.next = node;
                // 重置暂存的反转的node节点
                node = new ListNode(-1);
                // 当前结果节点指向 链表最后一个节点
                while (res.next != null)
                    res = res.next;
                count = 0;
            }
        }
        if (temp != null) // 如果有多余的节点 且达不到k个  直接连接到结果节点最后面
            res.next = temp;
        return start_node.next;
    }

}
