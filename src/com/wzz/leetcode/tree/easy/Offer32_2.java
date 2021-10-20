package com.wzz.leetcode.tree.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
 * [9,20],
 * [15,7]
 * ]
 *  
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 * 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class Offer32_2 {
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
