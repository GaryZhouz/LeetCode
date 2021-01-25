package com.wzz.leetcode.tree.easy;

/*
给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

示例:
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
          0
         / \
       -3   9
       /   /
     -10  5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L0402 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getTree(nums, 0, nums.length - 1);
    }

    private TreeNode getTree(int[] nums, int i, int length) {
        if (i > length) return null;
        int mid = (length - i) / 2 + i;
        //中点作为根节点
        TreeNode node = new TreeNode(nums[mid]);
        //左树
        node.left = getTree(nums, i, mid - 1);
        //右树
        node.right = getTree(nums, mid + 1, length);
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
