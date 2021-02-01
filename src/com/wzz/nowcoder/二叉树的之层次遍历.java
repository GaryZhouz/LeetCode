package com.wzz.nowcoder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Date 2021/2/1 10:34
 * @created by wzz
 */
public class 二叉树的之层次遍历 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
     * 例如：
     * 给定的二叉树是{3,9,20,#,#,15,7},
     * <p>
     * 该二叉树之字形层序遍历的结果是
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     * 示例1
     * 输入
     * {1,#,2}
     * 返回值
     * [[1],[2]]
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        // 存放当前层
        ArrayList<TreeNode> level = new ArrayList<>();
        // 存放所有层结果
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        level.add(root);
        // 标记是否需要逆序
        boolean flag = true;
        while (!level.isEmpty()) {
            // 每一层自反一次
            flag = !flag;
            // 暂存下一层的节点
            ArrayList<TreeNode> temp = new ArrayList<>();
            // 当前层的节点
            ArrayList<Integer> currentLevelNodes = new ArrayList<>();
            for (TreeNode treeNode : level) {
                currentLevelNodes.add(treeNode.val);
                if (treeNode.left != null)
                    temp.add(treeNode.left);
                if (treeNode.right != null)
                    temp.add(treeNode.right);
            }
            // 替换下一层
            level = temp;
            // 放入当前层结果,如果需要逆序就反转
            if (flag)
                Collections.reverse(currentLevelNodes);
            res.add(currentLevelNodes);
        }
        return res;
    }
}
