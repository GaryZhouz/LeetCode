package com.wzz.nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/1/26 9:30
 * @created by wzz
 */
public class 二叉树遍历 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * 分别按照二叉树先序，中序和后序打印所有的节点。
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */

    // 分别存储 先序 中序 后序的结果
    List<Integer> pre = new ArrayList<>();
    List<Integer> mid = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    public int[][] threeOrders(TreeNode root) {
        preOrders(root);
        midOrders(root);
        postOrders(root);
        int[][] res = new int[3][];
        res[0] = new int[pre.size()];
        res[1] = new int[mid.size()];
        res[2] = new int[post.size()];
        setRes(pre, res, 0);
        setRes(mid, res, 1);
        setRes(post, res, 2);
        return res;
    }

    private void setRes(List<Integer> list, int[][] res, int row) {
        for (int i = 0; i < list.size(); i++) {
            res[row][i] = list.get(i);
        }
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    private void postOrders(TreeNode node) {
        if (node == null)
            return;
        postOrders(node.left);
        postOrders(node.right);
        post.add(node.val);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    private void midOrders(TreeNode node) {
        if (node == null)
            return;
        midOrders(node.left);
        mid.add(node.val);
        midOrders(node.right);
    }

    /**
     * 先序遍历
     *
     * @param node
     */
    private void preOrders(TreeNode node) {
        if (node == null)
            return;
        pre.add(node.val);
        preOrders(node.left);
        preOrders(node.right);
    }

}
