package com.wzz.tree.easy;

/**
 * @Date 2020/11/13 15:19
 * @created by wzz
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 */
public class L111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        else if (root.left == null) //当前无左子树
            return minDepth(root.right) + 1;
        else if (root.right == null)//当前无右子树
            return minDepth(root.left) + 1;
        else//左右均有
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
