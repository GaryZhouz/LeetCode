package com.wzz.leetcode.array.easy;

/*
A 和 B 在一个 3 x 3 的网格上玩井字棋。
井字棋游戏的规则如下：
玩家轮流将棋子放在空方格 (" ") 上。
第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
"X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
如果所有方块都放满棋子（不为空），游戏也会结束。
游戏结束后，棋子无法再进行任何移动。
给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。
如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。

示例 1：
输入：moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
输出："A"
解释："A" 获胜，他总是先走。
"X  "    "X  "    "X  "    "X  "    "X  "
"   " -> "   " -> " X " -> " X " -> " X "
"   "    "O  "    "O  "    "OO "    "OOX"

示例 2：
输入：moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
输出："B"
解释："B" 获胜。
"X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
"   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
"   "    "   "    "   "    "   "    "   "    "O  "

示例 3：
输入：moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
输出："Draw"
输出：由于没有办法再行动，游戏以平局结束。
"XXO"
"OOX"
"XOX"

示例 4：
输入：moves = [[0,0],[1,1]]
输出："Pending"
解释：游戏还没有结束。
"X  "
" O "
"   "

提示：
1 <= moves.length <= 9
moves[i].length == 2
0 <= moves[i][j] <= 2
moves 里没有重复的元素。
moves 遵循井字棋的规则。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-winner-on-a-tic-tac-toe-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1275 {

    public static void main(String[] args) {
        System.out.println(new L1275().tictactoe(new int[][]{{2, 2}, {0, 2}, {1, 0}, {0, 1}, {2, 0}, {0, 0}}));
    }

    public String tictactoe(int[][] moves) {
        int[][] checkerboard = new int[3][3];//棋盘  1为A下的 2为B下的
        int rs = -1;//结果
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                //偶数为A的下的棋子
                checkerboard[moves[i][0]][moves[i][1]] = 1;
                //当前有获胜者
                if (checkWhoWin(checkerboard) == 1 || checkWhoWin(checkerboard) == 2) {
                    rs = checkWhoWin(checkerboard);
                    break;
                }
            } else {
                //B下的棋
                checkerboard[moves[i][0]][moves[i][1]] = 2;
                //当前获胜者
                if (checkWhoWin(checkerboard) == 1 || checkWhoWin(checkerboard) == 2) {
                    rs = checkWhoWin(checkerboard);
                    break;
                }
            }
        }

        return rs == 1 ? "A" : rs == 2 ? "B" : moves.length < 9 ? "Pending" : "Draw";
    }

    private int checkWhoWin(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            //判断横着是否有人赢
            if (x[i][0] == x[i][1] && x[i][0] == x[i][2]) return x[i][0];
            //判断竖着是否有人赢
            if (x[0][i] == x[1][i] && x[0][i] == x[2][i]) return x[0][i];
        }
        //判断斜着
        if ((x[0][0] == x[1][1] && x[0][0] == x[2][2])) return x[0][0];
        if ((x[0][2] == x[1][1] && x[0][2] == x[2][0])) return x[0][2];
        //无获胜者
        return -1;
    }
}
//for (int j = 0; j < checkerboard.length; j++) {
//        for (int k = 0; k < checkerboard[0].length; k++) {
//        System.out.print(checkerboard[j][k]);
//        }
//        System.out.println();
//        }
//        System.out.println(rs);
