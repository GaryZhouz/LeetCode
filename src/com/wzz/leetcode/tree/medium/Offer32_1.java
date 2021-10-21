package com.wzz.leetcode.tree.medium;

import com.sun.jmx.remote.internal.ArrayQueue;
import com.wzz.leetcode.tree.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
 * 返回：
 * <p>
 * [3,9,20,15,7]
 *  
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 */
public class Offer32_1 {
    public int[] levelOrder(TreeNode root) {
        return bfs(root);
    }

    private int[] bfs(TreeNode root) {
        // BFS
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        list.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                list.add(node.left.val);
                queue.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right.val);
                queue.add(node.right);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
