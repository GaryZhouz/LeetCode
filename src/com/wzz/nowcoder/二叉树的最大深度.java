package com.wzz.nowcoder;

/**
 * @Date 2021/2/5 20:28
 * @created by wzz
 */
public class 二叉树的最大深度 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * 题目描述
     * 求给定二叉树的最大深度，
     * 最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。
     * <p>
     * 示例1
     * 输入
     * {1,2}
     * 返回值
     * 2
     * 示例2
     * 输入
     * {1,2,3,4,#,#,5}
     * 返回值
     * 3
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
