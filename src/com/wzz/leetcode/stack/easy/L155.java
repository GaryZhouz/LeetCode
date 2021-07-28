package com.wzz.leetcode.stack.easy;

import java.util.Stack;

/**
 * @Date 2021/7/28 5:33 下午
 * @Created by zhouzhou.wang
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 * <p>
 * 提示：
 * <p>
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 */
public class L155 {
    class MinStack {
        Stack<Integer> stack = new Stack<>();

        // 存放最小值的栈
        Stack<Integer> min_stack = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            min_stack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            if (val <= min_stack.lastElement()){
                min_stack.push(val);
            }
            stack.push(val);
        }

        public void pop() {
            Integer pop = stack.pop();
            if (pop.equals(min_stack.lastElement())){
                min_stack.pop();
            }
        }

        public int top() {
            return stack.lastElement();
        }

        public int getMin() {
            return min_stack.lastElement();
//            int min = Integer.MAX_VALUE;
//            for (Integer integer : stack) {
//                min = Math.min(min, integer);
//            }
//            return min;
        }
    }
}
