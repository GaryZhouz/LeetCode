package com.wzz.leetcode.tree.easy;

import java.util.ArrayList;
import java.util.List;

/*
给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :

返回其后序遍历: [5,6,3,2,4,1].

 */
public class L590 {
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

    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) return list;
        if (root.children != null) {//孩子节点不为空 遍历孩子节点 后序遍历即为  左孩子 右孩子 根节点此模式一直下去
            for (Node item : root.children) {
                //调用本身一直到最深的子节点
                postorder(item);
            }
            //添加节点
            list.add(root.val);
        }
        return list;
    }
}
