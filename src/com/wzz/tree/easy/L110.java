package com.wzz.tree.easy;

/**
 * @Date 2020/11/13 14:35
 * @created by wzz
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 */
public class L110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        else return Math.abs(deep(root.left)-deep(root.right)) <= 1//当前左节点的最深深度 和 右节点最深深度 是否差值小于1
                && isBalanced(root.left)//递归继续找节点的左子节点
                && isBalanced(root.right);//递归继续找节点的右子节点
    }

    private int deep(TreeNode root) {//当前节点最深的深度
        if (root == null) return 0;
        else return Math.max(deep(root.left), deep(root.right)) + 1;
    }
}
