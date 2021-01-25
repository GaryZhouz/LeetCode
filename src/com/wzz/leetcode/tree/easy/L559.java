package com.wzz.leetcode.tree.easy;

import java.util.List;

/**
 * @Date 2020/11/13 14:51
 * @created by wzz
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 我们应返回其最大深度，3。
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 */
public class L559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public int maxDepth(Node root) {
        if (root == null) return 0;//如果当前节点为空 返回0,深度不增加
        else {
            int deep = 0;//节点最深的深度
            for (Node child : root.children) {
                deep = Math.max(deep, maxDepth(child) + 1);//比较当前深度 和 孩子节点的深度
            }
            return deep;
        }
    }
}
