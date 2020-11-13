package com.wzz.tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/11/13 10:02
 * @created by wzz
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * <p>
 * <p>
 * <p>
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * <p>
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * <p>
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 * 示例 5：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 给定的两棵树可能会有 1 到 200 个结点。
 * 给定的两棵树上的值介于 0 到 200 之间。
 */
public class L872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.toString().equals(list2.toString());
    }

    private void dfs(TreeNode root1, List<Integer> list1) {
        if (root1 == null)//当前节点为空
            return;
        if (root1.left == null && root1.right == null)//叶子节点
            list1.add(root1.val);
        dfs(root1.left, list1);
        dfs(root1.right, list1);
    }
}
