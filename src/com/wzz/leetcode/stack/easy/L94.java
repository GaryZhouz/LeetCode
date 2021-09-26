package com.wzz.leetcode.stack.easy;

import com.wzz.leetcode.tree.easy.TreeNode;
import com.wzz.nowcoder.在二叉树中找到两个节点最近的公共祖先;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 * <p>
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class L94 {

    public List<Integer> inorderTraversal(TreeNode root) {
//        return methodByStack(root);
        List<Integer> result = new ArrayList<>();
        methodByDec(root, result);
        return result;
    }

    private void methodByDec(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        methodByDec(root.left, result);
        result.add(root.val);
        methodByDec(root.right, result);
    }

    private List<Integer> methodByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            root = node.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(new L94().inorderTraversal(treeNode));
    }

}
