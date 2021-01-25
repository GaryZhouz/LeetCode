package com.wzz.leetcode.Array.easy;

import java.util.Arrays;
import java.util.HashSet;

/*
3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。

示例：
输入: [[4,3,8,4],
      [9,5,1,9],
      [2,7,6,2]]
输出: 1

解释:
下面的子矩阵是一个 3 x 3 的幻方：
438
951
276

而这一个不是：
384
519
762

总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。

提示:
1 <= grid.length <= 10
1 <= grid[0].length <= 10
0 <= grid[i][j] <= 15

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/magic-squares-in-grid
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L840 {
    public static void main(String[] args) {
        new L840().numMagicSquaresInside(new int[][]{{1, 1, 1}, {4, 5, 6}, {9, 9, 9}});
    }

    public int numMagicSquaresInside(int[][] grid) {
        //所有的幻方情况
        HashSet<String> all = new HashSet<>(Arrays.asList("816357492", "834159672", "618753294", "672159834",
                "492357816", "438951276", "294753618", "276951438"));
        HashSet<String> set = new HashSet<>();
        //所有幻方总数
        int count = 0;
        if (grid.length >= 3 && grid[0].length >= 3) {
            //遍历每一个三届矩阵 必须中心点为5才满足
            for (int i = 0; i < grid.length - 2; i++) {
                for (int j = 0; j < grid[0].length - 2; j++) {
                    if (grid[i + 1][j + 1] == 5) {
                        String check = check(
                                grid[i][j], grid[i][j + 1], grid[i][j + 2],
                                grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2],
                                grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2]
                        );
                        set.add(check);
                    }
                }
            }
            String[] toArray = set.toArray(new String[set.size()]);
            for (int i = 0; i < toArray.length; i++) {
                if (all.contains(toArray[i])) {
                    count++;
                }
            }
        } else {
            return 0;
        }
        return count;
    }

    public String check(int... nums) {
        //帮助去重 用于去重后判断是否满足每个数字不相同的条件
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //说明有重复的
        if (set.size() != nums.length) return null;

        String rs = "";
        for (int i = 0; i < nums.length; i++) {
            rs += "" + nums[i];
        }
        return rs;
    }

}
