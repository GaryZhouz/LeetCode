package com.wzz.nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/1/30 15:28
 * @created by wzz
 */
public class 在二叉树中找到两个节点最近的公共祖先 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * 题目描述
     * 给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
     * 示例1
     * 输入
     * [3,5,1,6,2,0,8,#,#,7,4],5,1
     * 返回值
     * 3
     *
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        if (root == null) return -1;
        if (o1 == root.val || o2 == root.val)
            return root.val;
        int left = lowestCommonAncestor(root.left, o1, o2);
        int right = lowestCommonAncestor(root.right, o1, o2);
        if (left == -1)
            return right;
        if (right == -1)
            return left;
        return root.val;
    }


}
