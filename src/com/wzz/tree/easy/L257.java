package com.wzz.tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/11/12 10:40
 * @created by wzz
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class L257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        handle(root, "", paths);
        return paths;
    }

    private void handle(TreeNode root, String str, List<String> paths) {
        if (root != null) {//当前节点不为空
            StringBuffer sb = new StringBuffer(str);
            sb.append(root.val);
            if (root.left == null && root.right == null) {//当前节点是叶子节点
                paths.add(sb.toString());
            } else {//非叶子节点
                sb.append("->");
                handle(root.left, sb.toString(), paths);
                handle(root.right, sb.toString(), paths);
            }
        }
    }
}
