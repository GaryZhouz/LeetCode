package com.wzz.leetcode.linkList.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 */
class LRUCache {

    private class BothWayLinkedNode {

        private Integer key;

        private Integer value;

        private BothWayLinkedNode left;

        private BothWayLinkedNode right;

        public BothWayLinkedNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public BothWayLinkedNode(Integer value) {
            this.value = value;
        }
    }

    private BothWayLinkedNode tempNode = new BothWayLinkedNode(-1);

    private BothWayLinkedNode virtualHead = new BothWayLinkedNode(0);

    private BothWayLinkedNode virtualTail = new BothWayLinkedNode(0);

    private final int maxCapacity;

    private final Map<Integer, BothWayLinkedNode> map;

    public LRUCache(int capacity) {
        maxCapacity = capacity;
        map = new HashMap<>(capacity);
        virtualHead.left = virtualTail;
        virtualTail.right = virtualHead;
    }

    public int get(int key) {
        BothWayLinkedNode result = map.getOrDefault(key, tempNode);
        if (result.value != -1) {
            moveToHead(result);
            virtualHead.left = result;
        }
        return result.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            BothWayLinkedNode node = new BothWayLinkedNode(key, value);
            addToHead(node);
            map.put(key, node);
            if (map.size() > maxCapacity) {
                map.remove(virtualTail.right.key);
                virtualTail.right = virtualTail.right.right;
                virtualTail.right.left = virtualTail;
            }
        } else {
            BothWayLinkedNode existNode = map.get(key);
            existNode.value = value;
            moveToHead(existNode);
        }
    }

    public void moveToHead(BothWayLinkedNode node) {
        // 邻节点的双指针互相指向
        node.right.left = node.left;
        node.left.right = node.right;
        // move head
        node.left = virtualHead.left;
        virtualHead.left.right = node;
        virtualHead.left = node;
        node.right = virtualHead;
    }

    public void addToHead(BothWayLinkedNode node) {
        node.left = virtualHead.left;
        virtualHead.left.right = node;
        virtualHead.left = node;
        node.right = virtualHead;
    }
}

// LinkedList remove api don't succeed, because o(n)
class LRUCache2 {
    private final int maxCapacity;

    private final Map<Integer, Integer> map;

    private final LinkedList<Integer> linkedList;


    public LRUCache2(int capacity) {
        maxCapacity = capacity;
        map = new HashMap<>(capacity);
        linkedList = new LinkedList<>();
    }

    public int get(int key) {
        int result = map.getOrDefault(key, -1);
        if (result != -1) {
            linkedList.remove((Object) key);
            linkedList.addFirst(key);
        }
        return result;
    }

    public void put(int key, int value) {
        if (map.size() == maxCapacity && !map.containsKey(key)) {
            map.remove(linkedList.getLast());
            linkedList.removeLast();
        }
        map.put(key, value);
        linkedList.remove((Object) key);
        linkedList.addFirst(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class L146 {

}
