package com.wzz.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

/**
 * @Date 2021/2/5 19:41
 * @created by wzz
 */
public class 设计getMin功能的栈 {

    /**
     * 题目描述
     * 实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
     * 示例1
     * 输入
     * [[1,3],[1,2],[1,1],[3],[2],[3]]
     * 返回值
     * [1,2]
     * 备注:
     * 有三种操作种类，op1表示push，op2表示pop，op3表示getMin。你需要返回和op3出现次数一样多的数组，
     * 表示每次getMin的答案
     * <p>
     * 1<=操作总数<=1000000
     * -1000000<=每个操作数<=1000000
     * 数据保证没有不合法的操作
     * <p>
     * return a array which include all ans for op3
     *
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    public int[] getMinStack(int[][] op) {
        Stack<Integer> stack = new Stack<>();
        // 存放getMin操作产生的值
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < op.length; i++) {
            if (op[i][0] == 1) {// 入栈操作
                stack.push(op[i][1]);
            } else if (op[i][0] == 2) {// 出栈操作
                stack.pop();
            } else if (op[i][0] == 3) {// getMin操作
                Optional<Integer> min = stack.parallelStream().min(Integer::compareTo);
                values.add(min.get());
            }
        }
        int[] res = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            res[i] = values.get(i);
        }
        return res;
    }
}
