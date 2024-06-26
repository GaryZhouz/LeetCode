package com.wzz.leetcode.array.easy;

import java.util.Arrays;

/*
给你一个由一些多米诺骨牌组成的列表 dominoes。
如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。

示例：
输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
输出：1

提示
1 <= dominoes.length <= 40000
1 <= dominoes[i][j] <= 9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1128 {
    public static void main(String[] args) {
        System.out.println(new L1128().numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}}));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int[] help = new int[100];//动态规划 存放当前数组中数字的次数
        for (int[] arr : dominoes) {
            Arrays.sort(arr);
            //如果相同 则当前数组的值对应的加1 例如1,2 就将help[12] = 1;
            res += help[Integer.parseInt(arr[0] + "" + arr[1])]++;
        }
        return res;
    }
}
