package com.wzz.nowcoder;

import java.util.ArrayList;

/**
 * @Date 2021/2/1 11:12
 * @created by wzz
 */
public class 螺旋矩阵 {
    public static void main(String[] args) {
        int[][] a = {{2, 3}};
        System.out.println(spiralOrder(a));
    }

    /**
     * 题目描述
     * 给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
     * 示例1
     * 输入
     * <p>
     * [[1,2,3],[4,5,6],[7,8,9]]
     * 返回值
     * <p>
     * [1,2,3,6,9,8,7,4,5]
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int left = 0, top = 0;
        while (top <= bottom && left <= right) {
            // 右
            for (int i = left; i <= right; i++)
                res.add(matrix[top][i]);
            top++;
            if (top > bottom)
                return res;
            // 下
            for (int i = top; i <= bottom; i++)
                res.add(matrix[i][right]);
            right--;
            if (left > right)
                return res;
            // 左
            for (int i = right; i >= left; i--)
                res.add(matrix[bottom][i]);
            bottom--;
            if (top > bottom)
                return res;
            // 上
            for (int i = bottom; i >= top; i--)
                res.add(matrix[i][left]);
            left++;
            if (left > right)
                return res;
        }
        return res;
    }
}
