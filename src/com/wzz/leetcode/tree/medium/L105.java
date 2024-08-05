package com.wzz.leetcode.tree.medium;

import com.wzz.leetcode.tree.easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 */
public class L105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, map, 0, inorder.length - 1, 0, inorder.length - 1);
    }
    // 前序 = [根 左子树 右子树]
    // 中序 = [左子树 根 右子树]
    private TreeNode build(int[] preorder, Map<Integer, Integer> map, int p_l, int p_r, int i_l, int i_r) {
        if (p_l > p_r) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_l]);
        int i_root_index = map.get(preorder[p_l]);
        int left_node_num = i_root_index - i_l;
        root.left = build(preorder, map, p_l + 1, p_l + left_node_num, i_l, i_root_index - 1);
        root.right = build(preorder, map, p_l + 1 + left_node_num, p_r, i_root_index + 1, i_r);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMappingIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMappingIndex.put(inorder[i], i);
        }
        return build2(preorder, inorderMappingIndex, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build2(int[] preorder, Map<Integer, Integer> inorderMappingIndex, int p_left, int p_right, int i_left, int i_right) {
        if (p_left > p_right || i_left > i_right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_left]);
        Integer rootInorderIndex = inorderMappingIndex.get(root.val);
        // 左子树节点个数
        int leftRootTotal = rootInorderIndex - i_left;
        // 左子树根的index(前序遍历 根 左子树 右子树 所以+1就是左子树的根)
        int leftSubTreeIndexStart = p_left + 1;
        int leftSubTreeIndexEnd = p_left + leftRootTotal;
        // 右子树
        int rightSubTreeIndexStart = p_left + leftRootTotal + 1;
        root.left = build(preorder, inorderMappingIndex, leftSubTreeIndexStart, leftSubTreeIndexEnd, i_left, rootInorderIndex - 1);
        root.right = build(preorder, inorderMappingIndex, rightSubTreeIndexStart, p_right, rootInorderIndex + 1, i_right);
        return root;
    }
}
