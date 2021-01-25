package com.wzz.leetcode.tree.easy;

/**
 * @Date 2020/11/13 14:25
 * @created by wzz
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class L101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    private boolean dfs(TreeNode p, TreeNode q) {//左子树 和 右子树
        if (p == null && q == null) return true;//左子树和右子树同时为空 直接返回true
        if (p == null || q == null) return false;//左子树 和 右子树 有一个为空 则此树不是镜像对称树
        return p.val == q.val && dfs(p.left, q.right) && dfs(p.right, q.left);
    }
}
