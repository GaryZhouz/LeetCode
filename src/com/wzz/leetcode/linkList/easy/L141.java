package com.wzz.leetcode.linkList.easy;

import com.wzz.leetcode.linkList.ListNode;

/**
 * @Date 2021/7/28 5:00 下午
 * @Created by zhouzhou.wang
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 */
public class L141 {
    public boolean hasCycle(ListNode head) {
//        List<ListNode> listNodes = new ArrayList<>();
//        while (head != null) {
//            if (listNodes.contains(head)){
//                return true;
//            }
//            listNodes.add(head);
//            head = head.next;
//        }
//        return false;
        ListNode fastPoint = new ListNode(-1);
        ListNode slowPoint = new ListNode(-1);
        fastPoint.next = head;
        slowPoint.next = head;
        while (fastPoint != null) {
            if (fastPoint == slowPoint) {
                return true;
            }
            fastPoint = fastPoint.next;
            if (fastPoint != null) {
                fastPoint = fastPoint.next;
            }
            slowPoint = slowPoint.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode snow = head, fast = head.next;
        while (fast != null) {
            if (fast == snow) {
                return true;
            }
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            snow = snow.next;
        }
        return false;
    }

}