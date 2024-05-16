package com.wzz.leetcode.tree.medium;

import com.wzz.leetcode.tree.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 */
public class Offer34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentLoad = new ArrayList<>();
        dfs(result, currentLoad, root, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> currentLoad, TreeNode root, int target) {
        if (root == null) {
            return;
        }
        target -= root.val;
        currentLoad.add(root.val);
        if (root.left == null && root.right == null && target == 0) {
            result.add(new ArrayList<>(currentLoad));
        }
        dfs(result, currentLoad, root.left, target);
        dfs(result, currentLoad, root.right, target);
        currentLoad.remove(currentLoad.size() - 1);
    }
}
