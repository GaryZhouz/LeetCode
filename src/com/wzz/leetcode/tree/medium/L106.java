package com.wzz.leetcode.tree.medium;

import com.wzz.leetcode.tree.easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 */
public class L106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> valueMappingIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueMappingIndex.put(inorder[i], i);
        }
        return build(postorder, valueMappingIndex, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode build(int[] postorder, Map<Integer, Integer> valueMappingIndex, int i_l, int i_r, int p_l, int p_r) {
        if (i_l > i_r || p_l > p_r) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[p_r]);
        int index = valueMappingIndex.get(root.val);
        int rightNodeCount = i_r - index;
        root.left = build(postorder, valueMappingIndex, i_l, index - 1, p_l, p_r - rightNodeCount - 1);
        root.right = build(postorder, valueMappingIndex, index + 1, i_r, p_r - rightNodeCount, p_r - 1);
        return root;
    }
}
