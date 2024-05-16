package com.wzz.leetcode.array.medium;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 *  
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 *  
 * <p>
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 */
public class Offer12 {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int target) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(target)) {
            return false;
        }
        if (target == word.length() - 1) {
            return true;
        }
        // 能走到这里的都是匹配上的，然后将其置为0，代表路线走过标记起来
        board[x][y] = '0';
        boolean flag = dfs(board, word, x + 1, y, target + 1) || dfs(board, word, x - 1, y, target + 1) ||
                dfs(board, word, x, y + 1, target + 1) || dfs(board, word, x, y - 1, target + 1);
        board[x][y] = word.charAt(target);
        return flag;
    }
}
