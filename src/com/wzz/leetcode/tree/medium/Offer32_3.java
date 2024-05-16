package com.wzz.leetcode.tree.medium;

import com.wzz.leetcode.tree.easy.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 *  
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *  
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 */
public class Offer32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> rowList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(Collections.singletonList(root.val));
        Queue<TreeNode> deque = new LinkedBlockingDeque<>();
        if (root.left != null) {
            deque.offer(root.left);
        }
        if (root.right != null) {
            deque.offer(root.right);
        }
        List<TreeNode> prevNodes = new ArrayList<>();
        List<TreeNode> rowNodes = new ArrayList<>();
        prevNodes.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (!checkNodeIsNotInNodeList(node, prevNodes)) {
                result.add(rowList);
                rowList = new ArrayList<>();
                prevNodes = rowNodes;
                rowNodes = new ArrayList<>();
            }
            rowList.add(node.val);
            rowNodes.add(node);
            if (node.left != null) {
                deque.offer(node.left);
            }
            if (node.right != null) {
                deque.offer(node.right);
            }
        }
        if (rowList.size() > 0) {
            result.add(rowList);
        }
        for (int i = 1; i < result.size(); i += 2) {
            Collections.reverse(result.get(i));
        }
        return result;
    }

    private boolean checkNodeIsNotInNodeList(TreeNode target, List<TreeNode> prevNodes) {
        for (TreeNode prevNode : prevNodes) {
            if (target == prevNode.left || target == prevNode.right) {
                return true;
            }
        }
        return false;
    }
}
