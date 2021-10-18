package com.wzz.leetcode.stack.easy;

import java.util.Objects;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 * <p>
 * 提示：
 * <p>
 * 各函数的调用总次数不超过 20000 次
 */
public class Offer30 {
    class MinStack {

        Stack<Integer> stack;

        Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if (minStack.isEmpty()) {
                minStack.push(x);
                stack.push(x);
                return;
            }
            if (x <= minStack.lastElement()) {
                minStack.push(x);
            }
            stack.push(x);
        }

        public void pop() {
            Integer pop = stack.pop();
            if (Objects.equals(pop, minStack.lastElement())) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.lastElement();
        }

        public int min() {
            return minStack.lastElement();
        }
    }
}
