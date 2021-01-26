package com.wzz.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * @Date 2021/1/26 13:25
 * @created by wzz
 */
public class 二叉树层序遍历 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
     * 例如：
     * 给定的二叉树是{3,9,20,#,#,15,7},
     * 该二叉树层序遍历的结果是
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     * 示例1
     * 输入
     * {1,2}
     * 返回值
     * [[1],[2]]
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        // 用来存当前的树的层
        ArrayList<TreeNode> level = new ArrayList<>();
        level.add(root);

        while (!level.isEmpty()) {// 当前层为空跳出循环
            // 临时存放层
            ArrayList<TreeNode> temp = new ArrayList<>();
            // 当前层结果
            ArrayList<Integer> tempRes = new ArrayList<>();
            for (TreeNode treeNode : level) {// 遍历当前层节点
                tempRes.add(treeNode.val);
                // 下面都是将下一层存放起来
                if (treeNode.left != null)
                    temp.add(treeNode.left);
                if (treeNode.right != null)
                    temp.add(treeNode.right);
            }
            // 下一层交给level
            level = temp;
            res.add(tempRes);
        }
        return res;
    }

}
