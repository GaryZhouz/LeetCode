package com.wzz.leetcode.backtrack.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class L77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        List<Integer> tempStorage = new ArrayList<>();
        fullCombinations(n, 1, k, res, tempStorage);
        return res;
    }

    public void fullCombinations(int n, int index, int maxIndex,
                                 List<List<Integer>> res, List<Integer> tempStorage) {
        if (tempStorage.size() == maxIndex) {
            res.add(new ArrayList<>(tempStorage));
            return;
        }
        for (int i = index; i <= n; i++) {
            tempStorage.add(i);
            // 裁枝不然超时间 - 下一轮搜索 设置的搜索起点要加1 因为组合数理不允许出现重复的元素
            fullCombinations(n, i + 1, maxIndex, res, tempStorage);
            tempStorage.remove(tempStorage.size() - 1);
        }
    }
}
