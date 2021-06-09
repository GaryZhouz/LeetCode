package com.wzz.leetcode.Array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/6/9 19:45
 * @created by wzz
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < rowIndex + 1; row++) {
            List<Integer> rowList = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    rowList.add(1);
                } else {
                    rowList.add(result.get(row - 1).get(col - 1) + result.get(row - 1).get(col));
                }
            }
            result.add(rowList);
        }
        return result.get(rowIndex);
    }
}
