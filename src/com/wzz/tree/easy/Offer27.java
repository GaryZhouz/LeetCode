package com.wzz.tree.easy;

/*
请完成一个函数，输入一个二叉树，该函数输出它的镜像。
例如输入：
     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：
     4
   /   \
  7     2
 / \   / \
9   6 3   1

示例 1：
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
 
限制
0 <= 节点个数 <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer27 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        swap(root);
        return root;
    }

    private void swap(TreeNode node) {
        if (node == null) return;
        if (node.left != null) swap(node.left);
        if (node.right != null) swap(node.right);

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
    /**
     * 执行用时：
     * 0 ms, 在所有 Java 提交中击败了 100.00%的用户
     * 内存消耗：37.1 MB, 在所有 Java 提交中击败了75.51%的用户
     */
}
