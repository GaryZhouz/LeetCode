package com.wzz.leetcode.tree.easy;

/**
 * @Date 2020/11/13 9:48
 * @created by wzz
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * <p>
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 */
public class offer0404 {

    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root);
        return flag;
    }

    private int dfs(TreeNode root) {
        if (root == null || !flag) return 0;
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;
        if (Math.abs(left - right) > 1)
            flag = false;
        return Math.max(left, right);
    }
}
