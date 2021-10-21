package com.wzz.leetcode.tree.medium;

import com.wzz.leetcode.tree.easy.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        if (A.val == B.val && checkIsNotLikeTree(A.left, B.left) && checkIsNotLikeTree(A.right, B.right)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean checkIsNotLikeTree(TreeNode origin, TreeNode target) {
        if (target == null) {
            return true;
        }
        if (origin == null) {
            return false;
        }
        if (origin.val == target.val) {
            return checkIsNotLikeTree(origin.left, target.left) && checkIsNotLikeTree(origin.right, target.right);
        } else {
            return false;
        }
    }

}
