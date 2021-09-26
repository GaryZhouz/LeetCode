package com.wzz.leetcode.stack.easy;

import com.wzz.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * <p>
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 *  
 * <p>
 * 提示：
 * <p>
 * N 叉树的高度小于或等于 1000
 * 节点总数在范围 [0, 10^4] 内
 */
public class L589 {
    public List<Integer> preorder(Node root) {
//        List<Integer> result = new ArrayList<>();
//        methodByDec(root, result);
//        return result;
        return methodByStack(root);
    }

    private List<Integer> methodByStack(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            // 反转他的孩子节点，让栈能够按愿顺序出栈
            Collections.reverse(node.children);
            stack.addAll(node.children);
        }
        return result;
    }

    private void methodByDec(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (Node child : root.children) {
            methodByDec(child, result);
        }
    }
}
