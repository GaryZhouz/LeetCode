package com.wzz.leetcode.stack.easy;

import com.wzz.leetcode.tree.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class L145 {
    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        methodByDec(root, result);
//        return result;
        return methodByStack(root);
    }

    private List<Integer> methodByStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // prev标志当前节点是否是上一次添加进去结果节点的父节点
            if (root.right == null || prev == root.right) {
                result.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }

    private void methodByDec(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        methodByDec(root.left, result);
        methodByDec(root.right, result);
        result.add(root.val);
    }
}
