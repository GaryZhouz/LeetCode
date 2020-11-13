package com.wzz.tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/11/13 10:11
 * @created by wzz
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * <p>
 *  
 * <p>
 * 示例 ：
 * <p>
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 * <p>
 * 5
 * / \
 * 3    6
 * / \    \
 * 2   4    8
 *  /        / \
 * 1        7   9
 * <p>
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 * 9
 *  
 * <p>
 * 提示：
 * <p>
 * 给定树中的结点数介于 1 和 100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 */
public class L897 {
    public TreeNode increasingBST(TreeNode root) {
        //中序遍历的顺序
        List<Integer> orderList = new ArrayList<>();
        //中序遍历的dfs方法
        inOrder(root, orderList);
        //构建新树
        TreeNode treeNode = new TreeNode(0);
        //拷贝一个指向原树的指针 防止原树的指针变化 无法返回正确答案
        TreeNode copy = treeNode;
        for (Integer cur : orderList) {
            copy.right = new TreeNode(cur);
            copy = copy.right;
        }
        return treeNode.right;
    }

    private void inOrder(TreeNode root, List<Integer> orderList) {
        if (root == null) return;
        inOrder(root.left, orderList);
        orderList.add(root.val);
        inOrder(root.right, orderList);
    }
}
