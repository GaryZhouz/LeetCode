package com.wzz.leetcode.Array.easy;

import java.util.Stack;

/**
 * @Date 2021/6/9 18:52
 * @created by wzz
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L66 {
    public int[] plusOne(int[] digits) {
        int needPlus = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += needPlus;
            if (digits[i] >= 10) {
                digits[i] -= 10;
                needPlus = 1;
            } else {
                needPlus = 0;
            }
            stack.push(digits[i]);
        }
        if (needPlus > 0){
            stack.push(needPlus);
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
